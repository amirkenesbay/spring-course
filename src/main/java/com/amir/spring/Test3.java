package com.amir.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog mySecondDog = context.getBean("myPet", Dog.class);
        myDog.say();
        mySecondDog.say();
        context.close();
    }
}
