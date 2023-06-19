package com.example.MonitoringLocation.service.implement;

import com.example.MonitoringLocation.model.AccountAccessStatus;
import com.example.MonitoringLocation.repositories.AccountAccessStatusRepository;
import com.example.MonitoringLocation.service.AccountAccessStatusService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountAccessStatusServiceImp implements AccountAccessStatusService {

    @Autowired
    private AccountAccessStatusRepository repository;
    @Override
    public void updateAccountAccessStatus(String email, String deviceInfo) {
        repository.save(new AccountAccessStatus(email, deviceInfo));
    }

    @Override
    public void removeAccountAccessStatus(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public boolean isDeviceAllowed(String email, String deviceInfo) {
        AccountAccessStatus status = repository.findByEmailAndDeviceInfo(email, deviceInfo);
        return status == null;
    }
}
