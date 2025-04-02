package com.fantasy.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fantasy.server.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query(nativeQuery = true, value = "select u1_0.user_id,u1_0.created_at,u1_0.email,u1_0.password,u1_0.username from users u1_0 where u1_0.email=:emailVar")
    User findOneByEmail(@Param("emailVar") String email);

    @Query(nativeQuery = true, value = "select u1_0.user_id,u1_0.created_at,u1_0.email,u1_0.password,u1_0.username from users u1_0 where u1_0.email=:emailVar and u1_0.password=:pw")
    User findOneByEmailAndPassword(@Param("emailVar") String email, @Param("pw") String password);

    @Query(nativeQuery = true, value = "select u1_0.user_id,u1_0.created_at,u1_0.email,u1_0.password,u1_0.username from users u1_0 where u1_0.username=:usernameVar")
    User findOneByUsername(@Param("usernameVar") String username);

    @Query(nativeQuery = true, value = "select u1_0.user_id,u1_0.created_at,u1_0.email,u1_0.enabled,u1_0.password,u1_0.username,u1_0.verification_code,u1_0.verification_expiration from users u1_0 where u1_0.email=:emailVar")
    Optional<User> findUserByEmail(@Param("emailVar") String email);

    Optional<User> findByEmail(String email);
    Optional<User> findByVerificationCode(String verificationCode);
    Optional<User> findByUsername(String username);
}
