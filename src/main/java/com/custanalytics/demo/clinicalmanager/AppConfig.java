package com.custanalytics.demo.clinicalmanager;

import com.custanalytics.demo.clinicalmanager.dao.UserRepository;
import com.custanalytics.demo.clinicalmanager.entity.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by were on 7/25/2016.
 */

@SpringBootApplication
public class AppConfig {

    private static Logger log = LoggerFactory.getLogger(AppConfig.class);

    void run(String... var1) throws Exception {

    }

    public static void main (String [] args){
        SpringApplication.run(AppConfig.class);
    }

    public CommandLineRunner demo(UserRepository userRepository){

        return (args)->{
            AppUser appUser2 = new AppUser();
            appUser2.setFirstName("John");
            appUser2.setLastName("Doe");
            userRepository.save(appUser2);
            AppUser appUser = new AppUser();
            appUser.setFirstName("John");
            appUser.setLastName("Doe");
            appUser.setLogin("testUser");
            appUser.setPassword("testPassword");
            userRepository.save(appUser);
          //  loginService.login("test", "test123r");
        };
    }

}
