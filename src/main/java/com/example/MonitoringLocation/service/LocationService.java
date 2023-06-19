package com.example.MonitoringLocation.service;

import com.example.MonitoringLocation.model.Location;

import java.util.List;

public interface LocationService {

    int insertLocation(Location location);

    int insertListLocation(List<Location> location);


    List<Location> getLocationByPersonId(Long personId);

    boolean isTableLocationExist(String tableName);


    Location getLocationsByTableNameNow(Long personId);
}
