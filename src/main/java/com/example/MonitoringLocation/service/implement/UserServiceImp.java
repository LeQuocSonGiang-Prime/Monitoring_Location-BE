package com.example.MonitoringLocation.service.implement;

import com.example.MonitoringLocation.model.User;
import com.example.MonitoringLocation.repositories.LocationRepositoryCustom;
import com.example.MonitoringLocation.repositories.UserRepository;
import com.example.MonitoringLocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private  UserRepository userRepository;



    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User checkUser(User user) {
      return   userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());

    }


}
