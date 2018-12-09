package com.pierceecom.blog.service;

import com.pierceecom.blog.client.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodetestApp {

    public static void main(String[] args) {
        SpringApplication.run(CodetestApp.class, args);
        Menu.runApp();
    }
}
