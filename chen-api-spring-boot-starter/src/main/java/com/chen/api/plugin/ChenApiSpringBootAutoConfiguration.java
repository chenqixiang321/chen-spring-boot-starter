package com.chen.api.plugin;

import com.api.core.service.ChenApiService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
@EnableConfigurationProperties(ChenApiProperties.class)
public class ChenApiSpringBootAutoConfiguration {

    @Autowired
    private ChenApiProperties chenApiProperties;

    private static Logger logger = LoggerFactory.getLogger(ChenApiSpringBootAutoConfiguration.class);

    @Bean
    public ChenApiService chenApiService() throws SQLException {
        if(chenApiProperties!=null && chenApiProperties.getTestChenApi().getEnable()){
            ChenApiService chenApiService = new ChenApiService(chenApiProperties.getTestChenApi().getUrl(),
                    chenApiProperties.getTestChenApi().getUsername(),chenApiProperties.getTestChenApi().getPassword());
            logger.info("chenApiService is init finish");
            return chenApiService;
        }
        logger.info("chenApiService is init null");
        return null;
    }

}
