package com.custanalytics.demo.clinicalmanager.service;

import com.custanalytics.demo.clinicalmanager.dao.ProviderRepository;
import com.custanalytics.demo.clinicalmanager.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Provider> findProviderByLastName(String lastName) {
        return providerRepository.findByLastName(lastName);
    }

    public Provider findById(Long id) {return providerRepository.findOne(id);}
}
