package com.amir.spring;

import org.springframework.stereotype.Component;

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

    public void init(){
        System.out.println("Init method");
    }

    public void destroy(){
        System.out.println("Destroy method");
    }
}
