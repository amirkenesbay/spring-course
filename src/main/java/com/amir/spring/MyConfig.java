package com.amir.spring;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("com.amir.spring")
@PropertySource("classpath:myApp.properties")
public class MyConfig {
    @Bean
    @Scope("prototype")
    public Pet catBean(){
        return new Cat();
    }

    @Bean
    public Person personBean(){
        return new Person(catBean());
    }

    @Bean
    public Person personBean2(){
        return new Person(catBean());
    }
}
