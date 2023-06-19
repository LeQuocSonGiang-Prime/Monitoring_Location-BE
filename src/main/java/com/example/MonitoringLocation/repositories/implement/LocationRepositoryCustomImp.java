package com.example.MonitoringLocation.repositories.implement;

import com.example.MonitoringLocation.model.Location;
import com.example.MonitoringLocation.repositories.LocationRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class LocationRepositoryCustomImp implements LocationRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    public static final int ERROR_CODE_OK = 1;
    public static final int ERROR_CODE_NOT_IMPLEMENT = 2;
    public static final int ERROR_CODE_TABLE_NOT_FOUND = 3;


    @Override
    @Transactional
    public void createLocationTableForPerson(Long personId) {
        String sql = "CREATE TABLE person_" + personId + "_locations (id BIGINT AUTO_INCREMENT PRIMARY KEY, time DATETIME, latitude DECIMAL(9,6), longitude DECIMAL(9,6));";
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Override
    @Transactional
    public void insertLocation(Location location) {
        String sql = "INSERT INTO person_" + location.getPersonId() + "_locations ( time, latitude, longitude) VALUES(?,?,?);";
        try {
            entityManager.createNativeQuery(sql)
                    .setParameter(1, location.getTime())
                    .setParameter(2, location.getLatitude())
                    .setParameter(3, location.getLongitude())
                    .executeUpdate();
            System.out.println("insert thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    @Transactional
    public List<Location> getLocationsByTableName(String tableName) {
        String sql = "SELECT * FROM " + tableName + " ORDER BY time ASC;";
        Query query = entityManager.createNativeQuery(sql, Location.class);
        return (List<Location>) query.getResultList();
    }

    @Override
    @Transactional
    public Location getLocationsByTableNameNow(String tableName) {
        String sql = "SELECT * FROM " + tableName + " WHERE time = (SELECT MAX(time) FROM " + tableName + ")";
        Query query = entityManager.createNativeQuery(sql, Location.class);
        return ((List<Location>) query.getResultList()).get(0);
    }

    @Override
    public boolean isTableExist(String tableName) {
        String sql = " SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'monitoring_location' AND TABLE_NAME = ?";
        Query query = entityManager.createNativeQuery(sql)
                .setParameter(1, tableName);
        return query.getSingleResult() != null;

    }

    @Override
    @Transactional
    public void removeTable(String tableName) {
        String sql = "DROP TABLE " + tableName;
        entityManager.createNativeQuery(sql).executeUpdate();
    }
}
//