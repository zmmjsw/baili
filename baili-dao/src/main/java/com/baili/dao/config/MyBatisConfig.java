package com.baili.dao.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.boot.autoconfigure.*;

@Configuration    
@EnableAutoConfiguration  
public class MyBatisConfig {  
    @Bean    
    @ConfigurationProperties(prefix="mybatis.configuration")    
    public org.apache.ibatis.session.Configuration getMyBatisRedis(){    
    	org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();  
        return config;    
    }    
        
}