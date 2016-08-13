package com.custanalytics.demo.clinicmanager.test;

import com.custanalytics.demo.clinicalmanager.AppConfig;
import com.custanalytics.demo.clinicalmanager.entity.Appointment;
import com.custanalytics.demo.clinicalmanager.service.AppointmentService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppConfig.class)
public class AppointmentServiceTest {
    @Autowired
    AppointmentService appointmentService;
    Long testAppUserId = 2L;

    @Test
    public void testCreateAppointment() {


        Appointment newAppointment = createAppointment("CreateAppointmentTest");
        Appointment createdAppointment = appointmentService.createAppointment(newAppointment, testAppUserId);
        assertTrue("Appointment was not persisted to the database, id is not greater than zero", createdAppointment.getId() > 0);
    }

    private Appointment createAppointment(String createAppointmentTest) {
        /**
         * @TODO Move data out to file that will load sample data
         */
        Long providerId = 39L;
        Long locationId = 48L;
        Long patientId = 3L;

        Appointment appointment = new Appointment();
        appointment.setProviderId(providerId);
        appointment.setLocationId(locationId);
        appointment.setPatientId(patientId);

        DateTime appointmentStartTime = DateTime.now();
        appointment.setStartTime(new Timestamp(appointmentStartTime.getMillis()));
        appointment.setEndTime(new Timestamp(appointmentStartTime.plusHours(1).getMillis()));
        return appointment;
    }

    @Test
    public void testModifyAppointment() {
        String modifiedValue = "Modified Appointment Val";
        Appointment newAppointment = createAppointment("ModifyAppointmentTest");
        Appointment createdAppointment = appointmentService.createAppointment(newAppointment, testAppUserId);
        createdAppointment.setNotes(modifiedValue);
        Appointment modifiedAppointment = appointmentService.saveAppointment(createdAppointment, testAppUserId);
        assertTrue("Modified Appointment, inserted into db instead of modified", createdAppointment.getId() == modifiedAppointment.getId());
        assertTrue("Modified Appointment;s last name was not persisted to db", modifiedAppointment.getNotes().equalsIgnoreCase(modifiedValue));
    }

    @Test
    public void testFindAppointmentById() {
        String randomSuffix = String.valueOf(System.currentTimeMillis() / Math.random());
        Appointment createdAppointment = getPersistedAppointment("FindAppointmentById_" + randomSuffix);
        Appointment foundAppointment = appointmentService.findAppointmentById(createdAppointment.getId());
    }

    @Test
    public void testFindProviderAppointments() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime providerTestDate = formatter.parseDateTime("01/08/2016");
        Long testProviderId = -9L;

        DateTime inclusiveTestStartTime = providerTestDate.withTime(10, 0, 0, 0);
        DateTime inclusiveTestEndTime = providerTestDate.withTime(12, 0, 0, 0);
        List<Appointment> appointments = appointmentService.findActiveAppointmentsByProvider(testProviderId, inclusiveTestStartTime.toDate(), inclusiveTestEndTime.toDate());
        assertEquals("Inclusive appointments should be 2", 2, appointments.size());

        DateTime exclusiveTestStartTime = providerTestDate.withTime(12, 30, 0, 0);
        DateTime exclusiveTestEndTime = providerTestDate.withTime(13, 30, 0, 0);
        List<Appointment> appointmentsTest2 = appointmentService.findActiveAppointmentsByProvider(testProviderId, exclusiveTestStartTime.toDate(), exclusiveTestEndTime.toDate());
        assertEquals("Exclusive appointments should be 0", 0, appointmentsTest2.size());
    }
    private Appointment getPersistedAppointment(String appointmentNotes) {

        Appointment newAppointment = createAppointment(appointmentNotes);
        newAppointment.setCreated(new Date());
        return appointmentService.createAppointment(newAppointment, testAppUserId);
    }


}
