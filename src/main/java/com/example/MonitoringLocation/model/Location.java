package com.example.MonitoringLocation.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity()

public class Location {

@Id
    private Long id;
    @Transient
    private Long personId;
    private LocalDateTime time;
    private double latitude;
    private double longitude;
    public Location() {}

    public Location(Long personId, LocalDateTime time, double latitude, double longitude) {
        this.personId = personId;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}