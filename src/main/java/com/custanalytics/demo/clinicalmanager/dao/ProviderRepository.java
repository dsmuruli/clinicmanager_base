package com.custanalytics.demo.clinicalmanager.dao;

import com.custanalytics.demo.clinicalmanager.entity.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
    List<Provider> findByLastName(String lastName);
}
