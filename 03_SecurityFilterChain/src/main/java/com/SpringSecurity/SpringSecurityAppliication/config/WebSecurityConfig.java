package com.SpringSecurity.SpringSecurityAppliication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
      // here we define that if we go to api link so /posts can be access by anyone , but /posts/** can only by admin for this you have to uncomment the login form and remove sessionCreationPolicy.STATELESS
      // but we can use better than this we can use jwt token 

        .authorizeHttpRequests(auth->auth
        .requestMatchers("/posts").permitAll() // so it endpoint can be accessible by public no need to use password here 
        .requestMatchers("/posts/**").hasAnyRole("ADMIN") // so it endpoint can be accessible by admin 
        
        .anyRequest().authenticated())
        .csrf(csrfConfig->csrfConfig.disable()) //it will disable the csrf login token and if we don't use login page so we don't need it csrf token either right
        .sessionManagement(sessionconfig-> sessionconfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // we will use JWT token for these 
         //.formLogin(Customizer.withDefaults());                // this will create a html login form by default but we don't need it on backend bcz it's a duty of frontend to create login page for us
           



        return httpSecurity.build();
    }

    @Bean
    UserDetailsService MyInMemoryUserDetails(){
        UserDetails normalUser=User.withUsername("rohit").password(passwordEncoder().encode("rohit1212")).roles("USER").build();

        UserDetails adminUser=User.withUsername("sirohi").password(passwordEncoder().encode("pass")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(normalUser,adminUser);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
