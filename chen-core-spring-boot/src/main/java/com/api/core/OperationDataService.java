package com.api.core;

import com.api.core.dao.model.TestConfiguration;

import java.util.List;

public interface OperationDataService {
    List<TestConfiguration> getAllTestConfiguration();

    void updateTestConfigurationCountByIdTag(String idTag);

    void updateTestConfigurationCount(TestConfiguration testConfiguration);
}
