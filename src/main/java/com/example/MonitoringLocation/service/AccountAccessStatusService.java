package com.example.MonitoringLocation.service;

public interface AccountAccessStatusService {

    void updateAccountAccessStatus(String email, String deviceInfo);

    void removeAccountAccessStatus(String email);

    boolean isDeviceAllowed(String username, String deviceInfo);
}
