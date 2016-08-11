package com.custanalytics.demo.clinicalmanager.dao;

import com.custanalytics.demo.clinicalmanager.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by were on 8/8/2016.
 */
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findProviderActiveAppointments(Long patientId, Date startDate, Date endDate);

    List<Appointment> findPatientActiveAppointments(Long patientId, Date startDate, Date endDate);
}
