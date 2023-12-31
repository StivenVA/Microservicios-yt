package com.example.microservicios.feignclients;

import com.example.microservicios.model.Bike;
import com.example.microservicios.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bike-service",url = "http://localhost:8003/bike")
public interface BikeFeignClient {
    @PostMapping()
    Bike save(@RequestBody Bike bike);

    @GetMapping
    List<Bike> getAll();

    @GetMapping("{userId}")
    List<Bike> getById(@PathVariable int userId);
}
