package com.custanalytics.demo.clinicalmanager.dao;

import com.custanalytics.demo.clinicalmanager.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by were on 8/3/2016.
 */
@Repository
public interface  PatientRepository  extends CrudRepository<Patient, Long> {

     List<Patient> findByLastName(String lastName);
}
