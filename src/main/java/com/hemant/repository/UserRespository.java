package com.hemant.repository;

import com.hemant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User,Integer> {
    Optional<User> findByUserEmail(String email);

}
