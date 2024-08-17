package com.SpringSecurity.SpringSecurityAppliication.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.SpringSecurityAppliication.Entity.SessionEntity;
import com.SpringSecurity.SpringSecurityAppliication.Entity.User;

@Repository
public interface SessionRepo extends JpaRepository<SessionEntity, Long> {
    Optional<SessionEntity> findByUserId(Long userId);
}
