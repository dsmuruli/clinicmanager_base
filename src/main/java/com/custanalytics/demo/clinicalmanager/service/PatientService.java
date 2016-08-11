package com.custanalytics.demo.clinicalmanager.service;

import com.custanalytics.demo.clinicalmanager.dao.PatientRepository;
import com.custanalytics.demo.clinicalmanager.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by were on 8/3/2016.
 */
@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findPatientById(Long patientId) {
        return patientRepository.findOne(patientId);
    }

    public List<Patient> findPatientByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    public void deletePatient(Long patientId) {
        patientRepository.delete(patientId);
    }

}
