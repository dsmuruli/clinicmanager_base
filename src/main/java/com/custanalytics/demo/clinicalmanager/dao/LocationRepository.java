package com.custanalytics.demo.clinicalmanager.dao;

import com.custanalytics.demo.clinicalmanager.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by were on 8/8/2016.
 */
public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> findByLocationName(String locationName);
}
