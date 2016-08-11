package com.custanalytics.demo.clinicmanager.test;

import com.custanalytics.demo.clinicalmanager.AppConfig;
import com.custanalytics.demo.clinicalmanager.entity.Patient;
import com.custanalytics.demo.clinicalmanager.service.PatientService;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by were on 8/3/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppConfig.class)
public class PatientServiceTest {
    @Autowired
    PatientService patientService;

    @Test
    public void testCreatePatient() {
        Patient newPatient = createPatient("CreatePatientTest");
        Patient createdPatient = patientService.savePatient(newPatient);
        Assert.assertTrue("Patient was not persisted to the database, id is not greater than zero", createdPatient.getId() > 0);
    }

    @Test
    public void testFindPatientById() {

        //Move this into a file and have test data bed that can be used for testing.
        Patient testPatient = createPatient("TestFindByPatientId");
        Patient createdPatient =patientService.createPatient(testPatient);
        Patient findByPatient = patientService.findPatientById(createdPatient.getId());
        testPatient = patientService.savePatient(testPatient);
        System.out.println("Patient Id: " + testPatient.getId());
        Assert.assertNotNull(findByPatient);
    }
    @Test
    public void testModifyPatient(){
        String modificationString1 = "Modification Test";
        Patient testPatient = createPatient("TestFindByPatientId");
        Patient savedTestPatient =patientService.createPatient(testPatient);
        savedTestPatient.setLastName(modificationString1);
        Patient modifiedPatient =patientService.savePatient(savedTestPatient);
        Assert.assertEquals( savedTestPatient.getLastName(),modifiedPatient.getLastName());
        Assert.assertEquals( savedTestPatient.getId(),modifiedPatient.getId());
    }
    @Test
    public void testDeletePatient(){
        String modificationString1 = "Modification Test";
        Patient testPatient = createPatient("TestDeletePatient");
        Patient savedTestPatient =patientService.createPatient(testPatient);
        patientService.deletePatient(savedTestPatient.getId());
        Patient deletedPatient = patientService.findPatientById(savedTestPatient.getId());
        Assert.assertNull("Patient with id: " + savedTestPatient.getId() + " was not deleted",deletedPatient );
    }

    private Patient createPatient(String patientLastName) {
        Patient patient = new Patient();
        patient.setFirstName("Test ");
        patient.setLastName(patientLastName);
        patient.setSalutation("Ms");

        DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
        DateTime dt = formatter.parseDateTime("05/24/1972");
        patient.setDob(dt.toDate());
        String imageId = String.valueOf(System.currentTimeMillis()) + "_" + patient.getLastName();
        patient.setIdImageLocation("//patient/IdentificationImages//" + imageId + "//");
        return patient;
    }
}
