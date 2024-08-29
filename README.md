Week 5 of learning SpringBoot , today we learn about Spring Security.
Spring Boot Learning - Week 5
Overview
In Week 5, I delved into Spring Security, focusing on key concepts that are crucial for securing Spring Boot applications. This week, I learned about the security context, security filter chain, JWT tokens, and handling authentication requests.

Topics Covered
1. Security Context
Understanding the Security Context: Explored how Spring Security manages authentication and authorization using the security context, which holds security-related information about the current user.
Accessing the Security Context: Learned how to retrieve and manipulate the security context within the application to make security-related decisions.
2. Security Filter Chain
Security Filter Chain: Studied how Spring Security uses a filter chain to intercept and manage incoming requests, applying various security measures like authentication and authorization checks.
Customizing the Filter Chain: Implemented and customized the security filter chain to cater to specific security requirements of the application.
3. JWT Token
Introduction to JWT: Learned about JSON Web Tokens (JWT) and their use in stateless authentication for securing APIs.
JWT Implementation: Implemented JWT-based authentication by generating tokens upon successful login and validating them for subsequent requests.
4. Authentication Request
Handling Authentication Requests: Set up endpoints to handle user login requests, verifying credentials and issuing JWT tokens upon successful authentication.
Custom Authentication Logic: Developed custom authentication logic to enhance security measures and meet specific application needs.
