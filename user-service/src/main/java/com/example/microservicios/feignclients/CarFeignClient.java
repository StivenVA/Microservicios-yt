package com.example.microservicios.feignclients;

import com.example.microservicios.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service",url = "http://localhost:8002/car")
public interface CarFeignClient {
    @PostMapping()
    Car save(@RequestBody Car car);

    @GetMapping
    List<Car> getAll();

    @GetMapping("{userId}")
    List<Car> getById(@PathVariable int userId);
}
