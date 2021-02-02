package com.api.core.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.api.core.dao.TestConfigureDao;
import com.api.core.dao.TestConfigureMapper;
import com.api.core.dao.model.TestConfiguration;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.List;

public class TestConfigureImpl implements TestConfigureDao {

    private SqlSessionFactory sessionFactory;

    public TestConfigureImpl(DruidDataSource druidDataSource){
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",transactionFactory,druidDataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(TestConfigureMapper.class);
        this.sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }


    @Override
    public List<TestConfiguration> getAllTestConfiguration() {
        SqlSession sqlSession = this.sessionFactory.openSession(false);
        List list;
        try {
            list = sqlSession.selectList("com.api.core.dao.TestConfigureMapper.getAllTestConfiguration");
        }finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public void updateTestConfigurationCountByIdTag(String idTag) {
        SqlSession sqlSession = this.sessionFactory.openSession();
        try{
            sqlSession.update("com.api.core.dao.TestConfigureMapper.updateTestConfigurationCountByIdTag",idTag);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public void updateTestConfigurationCount(TestConfiguration testConfiguration) {
        SqlSession sqlSession = this.sessionFactory.openSession();
        try{
            sqlSession.update("com.api.core.dao.TestConfigureMapper.updateTestConfigurationCount",testConfiguration);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }
}
