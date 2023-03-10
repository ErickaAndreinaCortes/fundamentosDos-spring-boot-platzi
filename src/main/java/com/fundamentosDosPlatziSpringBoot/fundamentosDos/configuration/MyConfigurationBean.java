package com.fundamentosDosPlatziSpringBoot.fundamentosDos.configuration;

import com.fundamentosDosPlatziSpringBoot.fundamentosDos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation() {
        return new MyBeanImplement();
    }

    @Bean
    public MyOperation beanOperationOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationOperationWithDependency(MyOperation myOperation) {
        return new MyBeanWithDpendencyImplement(myOperation);
    }
}

