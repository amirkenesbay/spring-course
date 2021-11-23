package com.amir.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
// Here will be created default bean id. It will be "dog", not "dogBean"!
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-wow");
    }

//    @PostConstruct
//    public void init(){
//        System.out.println("Init method");
//    }
//
//    @PreDestroy
//    public void destroy(){
//        System.out.println("Destroy method");
//    }
}
