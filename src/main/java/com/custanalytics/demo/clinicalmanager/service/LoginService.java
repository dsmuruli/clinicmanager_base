package com.custanalytics.demo.clinicalmanager.service;

import com.custanalytics.demo.clinicalmanager.dao.UserRepository;
import com.custanalytics.demo.clinicalmanager.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by were on 7/29/2016.
 */
@Service
public class LoginService {
@Autowired
    UserRepository userRepository;
    public AppUser login(String userName, String password){
        AppUser appUser = null;
        appUser =userRepository.login(userName, password);
        return appUser;
    }

    public AppUser register(AppUser newAppUser){
        AppUser persistedAppUser = null;
        return persistedAppUser;
    }
}
