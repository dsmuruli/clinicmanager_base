package com.custanalytics.demo.clinicalmanager.service;

import com.custanalytics.demo.clinicalmanager.dao.AppointmentRepository;
import com.custanalytics.demo.clinicalmanager.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment, Long appUserId) {
        /**
         * Insert validation code to make sure that code is read from
         */
        appointment.setCreated(new Date());
        appointment.setCreatedBy(appUserId);
        return appointmentRepository.save(appointment);
    }

    public Appointment saveAppointment(Appointment appointment, Long appUserId) {
        /**
         * Insert validation code to make sure that code is read from
         */
        setAppointmentUpdateAuditInfo(appointment, appUserId);
        return appointmentRepository.save(appointment);
    }


    public Appointment findAppointmentById(Long appointmentId) {
        return appointmentRepository.findOne(appointmentId);
    }

    public Appointment cancelAppointment(Long appointmentId, Long appUserId) {
        Appointment appointment = appointmentRepository.findOne(appointmentId);
        appointment.setCancelled(true);
        setAppointmentUpdateAuditInfo(appointment, appUserId);
        appointment = appointmentRepository.save(appointment);
        return appointment;
    }
    @Query("SELECT a FROM Appointment a WHERE a.providerId=:providerId and a.startDate>=:startDate and a.endDate <=:endDate")
    public List<Appointment> findActiveAppointmentsByProvider(@Param("providerId")Long providerId,@Param("startDate") Date startDate,@Param("endDate") Date endDate) {
        return appointmentRepository.findProviderActiveAppointments(providerId, startDate, endDate);
    }
    @Query("SELECT a FROM Appointment a WHERE a.providerId=:patientId and a.startDate>=:startDate and a.endDate <=:endDate")
    public List<Appointment> findActiveAppointmentsByPatient(@Param("patientId")Long patientId, @Param("startDate")Date startDate,@Param("endDate") Date endDate) {
        return appointmentRepository.findPatientActiveAppointments(patientId, startDate, endDate);
    }

    private void setAppointmentUpdateAuditInfo(Appointment appointment, Long appUserId) {
        appointment.setUpdated(new Date());
        appointment.setUpdatedBy(appUserId);
    }

}
