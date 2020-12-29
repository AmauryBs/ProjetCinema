package com.webservice.projetcinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CinemaApp {
    public static void main(String[] args) {
        SpringApplication.run(CinemaApp.class, args);
    }
}
