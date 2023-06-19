package com.example.MonitoringLocation.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="AccountAccessStatus")
@Data
public class AccountAccessStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String deviceInfo;

    public AccountAccessStatus(String email, String deviceInfo){
        this.email = email;
        this.deviceInfo = deviceInfo;
    }
    public AccountAccessStatus() {

    }
}
