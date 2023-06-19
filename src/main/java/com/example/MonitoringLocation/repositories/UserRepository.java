package com.example.MonitoringLocation.repositories;

import com.example.MonitoringLocation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users p  WHERE p.email = :email AND p.password = :password", nativeQuery = true)
    User findUserByEmailAndPassword(String email, String password);




    Optional<User> findByEmail(String email);
}
