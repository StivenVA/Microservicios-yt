package com.example.microservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviciosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosApplication.class, args);
    }

}
