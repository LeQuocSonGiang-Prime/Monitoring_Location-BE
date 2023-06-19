package com.example.MonitoringLocation.service;


import com.example.MonitoringLocation.payload.request.AuthenticationRequest;
import com.example.MonitoringLocation.payload.response.AuthenticationResponse;
import com.example.MonitoringLocation.payload.request.RegisterRequest;

public interface AuthenticationService {


    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse register(RegisterRequest request);
}
