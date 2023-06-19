package com.example.MonitoringLocation.service.implement;

import com.example.MonitoringLocation.model.Location;
import com.example.MonitoringLocation.repositories.LocationRepositoryCustom;
import com.example.MonitoringLocation.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.MonitoringLocation.repositories.implement.LocationRepositoryCustomImp.ERROR_CODE_OK;
import static com.example.MonitoringLocation.repositories.implement.LocationRepositoryCustomImp.ERROR_CODE_TABLE_NOT_FOUND;

@Service
public class LocationServiceImp implements LocationService {

    @Autowired
    private LocationRepositoryCustom locationRepositoryCustom;

    @Override
    public int insertLocation(Location location) {
        String tableName = "person_"+ location.getPersonId()+"_locations";
        if(locationRepositoryCustom.isTableExist(tableName)){
            //Table Location for person is EXIST
            locationRepositoryCustom.insertLocation(location);
            return ERROR_CODE_OK;
        }else
            return ERROR_CODE_TABLE_NOT_FOUND;


    }

    @Override
    public int insertListLocation(List<Location> listLocation) {
        String tableName = "person_"+ listLocation.get(0).getPersonId()+"_locations";
        if(locationRepositoryCustom.isTableExist(tableName)){
            for (Location l : listLocation)
                locationRepositoryCustom.insertLocation(l);
            return ERROR_CODE_OK;
        }
       return ERROR_CODE_TABLE_NOT_FOUND;

    }


    @Override
    public List<Location> getLocationByPersonId(Long personId) {
        String tableName = "person_" + personId + "_locations";
        return locationRepositoryCustom.getLocationsByTableName(tableName);
    }

    @Override
    public boolean isTableLocationExist(String tableName) {
        return locationRepositoryCustom.isTableExist(tableName);
    }

    @Override
    public Location getLocationsByTableNameNow(Long personId) {
        String tableName = "person_" + personId + "_locations";
        return locationRepositoryCustom.getLocationsByTableNameNow(tableName);
    }
}
