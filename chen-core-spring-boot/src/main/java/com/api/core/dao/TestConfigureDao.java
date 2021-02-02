package com.api.core.dao;

import com.api.core.dao.model.TestConfiguration;

import java.util.List;

public interface TestConfigureDao {
    List<TestConfiguration> getAllTestConfiguration();

    void updateTestConfigurationCountByIdTag(String idTag);

    void updateTestConfigurationCount(TestConfiguration testConfiguration);
}
