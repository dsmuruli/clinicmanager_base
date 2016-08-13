package com.custanalytics.demo.clinicalmanager.dao;

import com.custanalytics.demo.clinicalmanager.entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by were on 8/8/2016.
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    @Query("SELECT a FROM Appointment a WHERE a.providerId = :providerId and a.startTime >= :startTime and a.endTime <= :endTime")
    List<Appointment> findProviderActiveAppointments(@Param("providerId") Long providerId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    @Query("SELECT a FROM Appointment a WHERE a.patientId = :patientId and a.startTime >= :startTime and a.endTime <= :endTime")
    List<Appointment> findPatientActiveAppointments(@Param("patientId") Long patientId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
