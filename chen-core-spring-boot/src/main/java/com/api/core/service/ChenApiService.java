package com.api.core.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.api.core.OperationDataService;
import com.api.core.OperationDataServiceImpl;
import com.api.core.dao.TestConfigureDao;
import com.api.core.dao.impl.TestConfigureImpl;
import com.api.core.dao.model.TestConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class ChenApiService {

    private Logger logger = LoggerFactory.getLogger(ChenApiService.class);

    private DruidDataSource dataSource;

    private OperationDataService operationDataService;

    public ChenApiService(String url,String username,String pwd) throws SQLException {
        this.dataSource= new DruidDataSource();
        this.dataSource.setUrl(url);
        this.dataSource.setUsername(username);
        this.dataSource.setPassword(pwd);
        this.dataSource.init();
        TestConfigureDao dao = new TestConfigureImpl(dataSource);
        this.operationDataService = new OperationDataServiceImpl();
        ((OperationDataServiceImpl)this.operationDataService).setTestConfigureDao(dao);
    }

    public List<TestConfiguration> getAllTestConfiguration(){
       return operationDataService.getAllTestConfiguration();
    }

    public void updateTestConfigurationCountByIdTag(String idTag){
        operationDataService.updateTestConfigurationCountByIdTag(idTag);
    }

    public void updateTestConfigurationCount(TestConfiguration testConfiguration){
        operationDataService.updateTestConfigurationCount(testConfiguration);
    }
}
