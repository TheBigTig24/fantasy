package com.fantasy.server.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fantasy.server.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
    
}
