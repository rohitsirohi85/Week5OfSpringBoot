package com.SpringSecurity.SpringSecurityAppliication.services;

import org.springframework.stereotype.Service;

import com.SpringSecurity.SpringSecurityAppliication.Entity.SessionEntity;
import com.SpringSecurity.SpringSecurityAppliication.Entity.User;

@Service
public interface SessionService {
    SessionEntity createSession(User user, String token);
    SessionEntity getSessionByUserId(Long userId);

}