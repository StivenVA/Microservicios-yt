package com.example.motos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MotosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotosApplication.class, args);
    }

}
