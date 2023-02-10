package com.fundamentosDosPlatziSpringBoot.fundamentosDos.configuration;

import com.fundamentosDosPlatziSpringBoot.fundamentosDos.bean.MyBeanWithPrperties;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.bean.MyBeanWithPrpertiesImplement;
import com.fundamentosDosPlatziSpringBoot.fundamentosDos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

@Value("${jdbc.url}")
private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    @Bean
    public MyBeanWithPrperties function() {
        return new MyBeanWithPrpertiesImplement(name, apellido);
    }


    //configuración a nivel de base de datos, para conectar con la base de datos por acá y no por properties

    //lo comnte para poder hacer la concexión que sigue
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}
