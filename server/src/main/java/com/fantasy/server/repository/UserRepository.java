package com.fantasy.server.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fantasy.server.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
    
    @Query(nativeQuery = true, value = "select u1_0.user_id,u1_0.created_at,u1_0.email,u1_0.password,u1_0.username from users u1_0 where u1_0.email=:emailVar")
    User findOneByEmail(@Param("emailVar") String email);

    @Query(nativeQuery = true, value = "select u1_0.user_id,u1_0.created_at,u1_0.email,u1_0.password,u1_0.username from users u1_0 where u1_0.email=:emailVar and u1_0.password=:pw")
    User findOneByEmailAndPassword(@Param("emailVar") String email, @Param("pw") String password);

    @Query(nativeQuery = true, value = "select u1_0.user_id,u1_0.created_at,u1_0.email,u1_0.password,u1_0.username from users u1_0 where u1_0.username=:usernameVar")
    User findOneByUsername(@Param("usernameVar") String username);
}
