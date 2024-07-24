package com.e_commerce.cliqueshoppa.data.repositories;

import com.e_commerce.cliqueshoppa.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
