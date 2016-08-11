package com.custanalytics.demo.clinicmanager.test;

import com.custanalytics.demo.clinicalmanager.AppConfig;
import com.custanalytics.demo.clinicalmanager.entity.Location;
import com.custanalytics.demo.clinicalmanager.service.LocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppConfig.class)
public class LocationServiceTest {

    @Autowired
    LocationService locationService;

    @Test
    public void testCreateLocationTest() {
        Location newLocation = createLocation("LocationCreateTest");
        Location createdLocation = locationService.createLocation(newLocation);
        assertTrue("Provider was not persisted to the database, id is not greater than zero", createdLocation.getId() > 0);
    }

    @Test
    public void modifyLocationTest() {

        String locationNameRoot = "LocationModifyTest";
        String randomSuffix = getRandomValue();
        String locationName1 = locationNameRoot + randomSuffix;
        Location newLocation = createLocation(locationName1);
        Location createdLocation = locationService.createLocation(newLocation);

        String randomSuffix2 = getRandomValue();
        String locationName2 = locationNameRoot + randomSuffix2;
        createdLocation.setLocationName(locationName2);
        Location modifiedLocation = locationService.saveLocation(createdLocation);

        assertTrue("Location was not modified, modified location id is not  same as original location",
                modifiedLocation.getId() == createdLocation.getId());
        assertTrue("location name not modified, name should be " + locationName2,locationName2.equalsIgnoreCase(modifiedLocation.getLocationName()));
    }

    private String getRandomValue() {
        return String.valueOf( Math.round(System.currentTimeMillis() ) / Math.random());
    }

    @Test
    public void findLocationByNameTest() {
        String locationNameRoot = "LocationByNameTest";
        String randomSuffix = getRandomValue();
        String locationName = locationNameRoot + randomSuffix;
        Location testLocation =createLocation(locationName);
        locationService.createLocation(testLocation);
        List<Location> foundLocationNameList =locationService.findByLocationName(locationName);
        assertTrue("Did not find exactly one location with location name: " + locationName, foundLocationNameList.size()==1);
        assertTrue("", foundLocationNameList.get(0).getLocationName().equalsIgnoreCase(locationName));
    }

    private Location createLocation(String locationName) {
        Location location = new Location();
        location.setLocationName(locationName);
        location.setAddress1("2334 Main");
        location.setAddress2("Suite 3456");
        location.setCity("San Francisco");
        location.setPostalCode("16802");
        location.setStateProvince("California");
        location.setMainNumber("415-233-1212");
        return location;

    }
}
