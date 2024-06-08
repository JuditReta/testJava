package com.api.test.auth.repository;

import com.api.test.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    //List<User> findByNameContains(String name);

    Optional<User> findByUsername(String username);
}
