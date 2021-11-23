package com.amir.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.amir.spring")
public class MyConfig {
    @Bean
    public Pet catBean(){
        return new Cat();
    }
}
