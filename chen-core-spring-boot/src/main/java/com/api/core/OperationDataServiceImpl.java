package com.api.core;

import com.api.core.dao.TestConfigureDao;
import com.api.core.dao.model.TestConfiguration;

import java.util.List;

public class OperationDataServiceImpl implements OperationDataService{

    private TestConfigureDao testConfigureDao;

    @Override
    public List<TestConfiguration> getAllTestConfiguration() {
        return testConfigureDao.getAllTestConfiguration();
    }

    @Override
    public void updateTestConfigurationCountByIdTag(String idTag) {
         testConfigureDao.updateTestConfigurationCountByIdTag(idTag);
    }

    @Override
    public void updateTestConfigurationCount(TestConfiguration testConfiguration) {
        testConfigureDao.updateTestConfigurationCount(testConfiguration);
    }

    public TestConfigureDao getTestConfigureDao() {
        return testConfigureDao;
    }

    public void setTestConfigureDao(TestConfigureDao testConfigureDao) {
        this.testConfigureDao = testConfigureDao;
    }
}
