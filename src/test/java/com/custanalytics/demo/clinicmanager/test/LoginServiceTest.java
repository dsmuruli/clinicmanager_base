package com.custanalytics.demo.clinicmanager.test;

import com.custanalytics.demo.clinicalmanager.AppConfig;
import com.custanalytics.demo.clinicalmanager.entity.AppUser;
import com.custanalytics.demo.clinicalmanager.service.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppConfig.class)
public class LoginServiceTest {
    @Autowired
private LoginService loginService ;

    @Test
    public void testLogin(){
        AppUser user =loginService.login("testUser", "testPassword");
        Assert.assertNotNull(user);
    }

    @Test
    public void testNegativeLogin(){
        AppUser appUserDoesNotExist = loginService.login("UserDoesNotExist", "passwordDoesNotExist");
        Assert.assertNull(appUserDoesNotExist);
    }
}
