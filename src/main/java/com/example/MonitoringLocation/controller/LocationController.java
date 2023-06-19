package com.example.MonitoringLocation.controller;

import com.example.MonitoringLocation.model.Location;
import com.example.MonitoringLocation.payload.response.ResponseObject;
import com.example.MonitoringLocation.service.LocationService;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.MonitoringLocation.repositories.implement.LocationRepositoryCustomImp.*;

@RestController
@RequestMapping("monitoring-location/api/v1/location")
public class LocationController {

    @Autowired
    private LocationService locationService;
    private RateLimiter rateLimiter = RateLimiter.create(40.0);


    @GetMapping("/{person_id}")
    public ResponseEntity<ResponseObject> getLocationByUser(@PathVariable Long person_id) {
        System.out.println("dang lay data");
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query location successfully!", locationService.getLocationByPersonId(person_id))
        );
    }

    @GetMapping("/now/{person_id}")
    public ResponseEntity<ResponseObject> getLocationByUserNow(@PathVariable Long person_id) {
        System.out.println("dang lay data now");
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query location successfully!", locationService.getLocationsByTableNameNow(person_id))
        );
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertLocation(@RequestBody Location location) {
        // if (rateLimiter.tryAcquire()) {
        System.out.println(location);
        int insertResult = locationService.insertLocation(location);
        return switch (insertResult) {
            case ERROR_CODE_OK -> ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Insert location successfully!", null)
            );
            case ERROR_CODE_TABLE_NOT_FOUND -> ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body(
                    new ResponseObject("FAILED", "Table not found!", null)
            );
            default -> ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILED", "Insert location is failed!", null)
            );
        };
    }

    @PostMapping("insertList")
    public ResponseEntity<ResponseObject> insertListLocation(@RequestBody List<Location> location) {
    int insertResult = locationService.insertListLocation(location);
        return switch (insertResult) {
            case ERROR_CODE_OK -> ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Insert list location successfully!", null)
            );
            case ERROR_CODE_TABLE_NOT_FOUND -> ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body(
                    new ResponseObject("FAILED", "Table not found!", null)
            );
            default -> ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("FAILED", "Insert location is failed!", null)
            );
        };
    }


}
