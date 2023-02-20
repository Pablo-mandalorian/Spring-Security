package com.pablotelles.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.pablotelles.springsecurity.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findOneByEmail(String email);
}
