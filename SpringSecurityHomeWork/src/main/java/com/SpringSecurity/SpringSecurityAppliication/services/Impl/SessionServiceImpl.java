package com.SpringSecurity.SpringSecurityAppliication.services.Impl;

import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Comparator;
import java.time.LocalDateTime;

import com.SpringSecurity.SpringSecurityAppliication.Entity.SessionEntity;
import com.SpringSecurity.SpringSecurityAppliication.Entity.User;
import com.SpringSecurity.SpringSecurityAppliication.repo.SessionRepo;
import com.SpringSecurity.SpringSecurityAppliication.services.SessionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepo sessionRepo;

    @Override
    public SessionEntity createSession(User user, String token) {
        SessionEntity session = sessionRepo.findByUserId(user.getId()).orElse(new SessionEntity());
        session.setUser(user);
        session.setToken(token);
        return sessionRepo.save(session);
    }

    @Override
    public SessionEntity getSessionByUserId(Long userId) {
        return sessionRepo.findByUserId(userId).orElse(null);
    }
}

    

