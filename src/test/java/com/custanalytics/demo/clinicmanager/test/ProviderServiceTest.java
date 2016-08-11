package com.custanalytics.demo.clinicmanager.test;

import com.custanalytics.demo.clinicalmanager.AppConfig;
import com.custanalytics.demo.clinicalmanager.entity.Provider;
import com.custanalytics.demo.clinicalmanager.service.ProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppConfig.class)
public class ProviderServiceTest {

    @Autowired
    ProviderService providerService;

    @Test
    public void testCreateProvider() {
        Provider newProvider = createProvider("CreateProviderTest");
        Provider createdProvider = providerService.createProvider(newProvider);
        assertTrue("Provider was not persisted to the database, id is not greater than zero", createdProvider.getId() > 0);
    }

    @Test
    public void tesModifyProvider() {
        String modifiedValue = "Modified Provider Val";
        Provider newProvider = createProvider("ModifyProviderTest");
        Provider createdProvider = providerService.createProvider(newProvider);
        createdProvider.setLastName(modifiedValue);
        Provider modifiedProvider = providerService.saveProvider(createdProvider);
        assertTrue("Modified Provider, inserted into db instead of modified", createdProvider.getId()==modifiedProvider.getId());
        assertTrue("Modified Provider;s last name was not persisted to db",modifiedProvider.getLastName().equalsIgnoreCase(modifiedValue));
    }

    @Test
    public void testFindProviderById() {
        String randomSuffix = String.valueOf(System.currentTimeMillis() / Math.random());
        Provider createdProvider =getPersistedProvider("FindProviderById_"+ randomSuffix);
        Provider foundProvider =providerService.findById(createdProvider.getId());
    }

    @Test
    public void testFindProviderByLastName(){
        String randomSuffix = String.valueOf(System.currentTimeMillis() / Math.random());
        String providerLastName = "FindProviderByLastName_"+randomSuffix;
        Provider createdProvider =getPersistedProvider(providerLastName);
        List<Provider> foundByLastNameProviderList =providerService.findProviderByLastName(providerLastName);
        assertEquals("more than one provider was found with the lastName " + providerLastName,foundByLastNameProviderList.size(),1);

    }

    private Provider getPersistedProvider(String providerLastName) {
        Provider newProvider = createProvider(providerLastName);
        return providerService.createProvider(newProvider);
    }

    public void softDeleteProvider() {

    }

    private Provider createProvider(String providerName) {
        Provider createdProvider = new Provider();
        String randomSuffix = String.valueOf(System.currentTimeMillis() / Math.random());
        createdProvider.setFirstName("Unit Test_" + randomSuffix);
        createdProvider.setLastName(providerName);
        createdProvider.setSalutation("Dr");
        createdProvider.setTelno("780-233-1234");
        createdProvider.setCreated(new Date());
        createdProvider.setCreatedBy(-99L);
        return createdProvider;
    }


}
