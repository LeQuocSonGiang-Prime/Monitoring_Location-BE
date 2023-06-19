package com.example.MonitoringLocation.service;

import com.example.MonitoringLocation.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User checkUser(User user);
}
