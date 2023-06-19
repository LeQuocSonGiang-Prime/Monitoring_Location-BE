package com.example.MonitoringLocation.controller;

import com.example.MonitoringLocation.payload.response.ResponseObject;
import com.example.MonitoringLocation.model.User;
import com.example.MonitoringLocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("monitoring-location/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseObject> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Sign up is Successfull!", userService.createUser(user))
        );
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseObject> signin(@RequestBody User user) {
        User userFound = userService.checkUser(user);
        if(userFound!=null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","Login is Successfull!", userFound)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("NOT_FOUND","Login is Failed!", null)
            );
        }


    }
}
