package com.example.MonitoringLocation.auth;


import com.example.MonitoringLocation.payload.request.AuthenticationRequest;
import com.example.MonitoringLocation.payload.request.RegisterRequest;
import com.example.MonitoringLocation.payload.response.AuthenticationResponse;
import com.example.MonitoringLocation.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("monitoring-location/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
      return  ResponseEntity.ok(authenticationService.register(request));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){

        return  ResponseEntity.ok(authenticationService.authenticate(request));

    }

}
