package com.fundamentos.platzi.springboot.Fundamentos.Configuration;

import com.fundamentos.platzi.springboot.Fundamentos.Beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigBean {
    @Bean
    public MyBean BeanOperation(){
        // return new MyBeanImplement();
        return new MyBeanImplementTwo();
    }

    @Bean
    public MyOperation BeanOperationSum(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependencyImplement BeanOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

}
