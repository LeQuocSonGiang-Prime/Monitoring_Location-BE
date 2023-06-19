package com.example.MonitoringLocation.repositories;

import com.example.MonitoringLocation.model.AccountAccessStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountAccessStatusRepository extends JpaRepository<AccountAccessStatus, Long> {

    void deleteByEmail(String name);

    AccountAccessStatus findByEmailAndDeviceInfo(String email, String deviceInfo);
}
