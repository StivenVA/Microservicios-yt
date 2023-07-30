package com.example.carros.controller;


import com.example.carros.entity.Car;
import com.example.carros.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){

        List<Car> cars = carService.getAll();

        if (cars.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(cars);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Car> getById(@PathVariable int id){

        Car car = carService.getById(id);

        if (car==null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){

        Car carNew = carService.save(car);

        return ResponseEntity.ok(car);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable int userId){

        List<Car> cars = carService.findByUserId(userId);

        if(cars.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cars);
    }

}
