package com.SpringSecurity.SpringSecurityAppliication.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SpringSecurity.SpringSecurityAppliication.Entity.SessionEntity;
import com.SpringSecurity.SpringSecurityAppliication.repo.SessionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionService {
    
    private final SessionRepo sessionRepo;

       public void createSession(Long userId ,String token){
             sessionRepo.deleteByUserId(userId);
             SessionEntity sessionEntity = new SessionEntity();
             sessionEntity.setUserId(userId);
             sessionEntity.setToken(token);
             sessionRepo.save(sessionEntity);
       }

         public boolean isValid(Long userId , String token){
            Optional<SessionEntity> sessionEntity = sessionRepo.findByUserId(userId);
            return sessionEntity.isPresent() && sessionEntity.get().getToken().equals(token);
         }

}
