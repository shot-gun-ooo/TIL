package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);


    }

    public void sayHello() {
        System.out.println("Hello from Demo1Application!");
    }

    public int addNumbers(int a, int b) {
        return a + b;
    }

    public String getStatus() {
        return "Application is running";
    }




}
