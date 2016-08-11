package com.custanalytics.demo.clinicalmanager.service;

import com.custanalytics.demo.clinicalmanager.dao.LocationRepository;
import com.custanalytics.demo.clinicalmanager.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location findLocationtById(Long locationId) {
        return locationRepository.findOne(locationId);
    }

    public List<Location> findAllLocations() {
        List<Location> locations = new ArrayList<Location>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public List<Location> findByLocationName(String locationName) {
        return locationRepository.findByLocationName(locationName);
    }

}
