package com.example.MonitoringLocation.repositories;

import com.example.MonitoringLocation.model.Location;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepositoryCustom {
    void createLocationTableForPerson( Long personId);
    void insertLocation(Location location);

    List<Location> getLocationsByTableName(String tableName);

    Location getLocationsByTableNameNow(String tableName);

    boolean isTableExist(String tableName);

    void removeTable(String tableName);
}
