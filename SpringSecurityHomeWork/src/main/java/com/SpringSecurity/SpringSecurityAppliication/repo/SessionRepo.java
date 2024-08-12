package com.SpringSecurity.SpringSecurityAppliication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.SpringSecurityAppliication.Entity.SessionEntity;

@Repository
public interface SessionRepo extends JpaRepository<SessionEntity , Long>{

    void deleteByUserId(Long userId);

    Optional<SessionEntity> findByUserId(Long userId);
    
}
