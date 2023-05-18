package com.fundamentos.platzi.springboot.Fundamentos.Configuration;

import com.fundamentos.platzi.springboot.Fundamentos.Beans.MyBeanWithProperties;
import com.fundamentos.platzi.springboot.Fundamentos.Beans.MyBeanWithPropertiesImplements;
import com.fundamentos.platzi.springboot.Fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfig {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplements(name, lastName);
    }
}
