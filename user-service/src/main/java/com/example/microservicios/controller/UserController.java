package com.example.microservicios.controller;

import com.example.microservicios.entity.User;
import com.example.microservicios.model.Bike;
import com.example.microservicios.model.Car;
import com.example.microservicios.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> users = userService.getAll();

        if (users.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){

        User user = userService.getById(id);

        if (user==null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){

        User userNew = userService.save(user);

        return ResponseEntity.ok(userNew);
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCarsById(@PathVariable int userId){
        User user = userService.getById(userId);
        if (user==null) return ResponseEntity.notFound().build();

        List<Car> cars = userService.getCarsById(userId);
        return ResponseEntity.ok(cars);

    }

    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> getBikesById(@PathVariable int userId){
        User user = userService.getById(userId);
        if (user==null) return ResponseEntity.notFound().build();

        List<Bike> bikes = userService.getBikesById(userId);
        return ResponseEntity.ok(bikes);

    }

    @GetMapping("/bikes")
    public ResponseEntity<List<Bike>> getBikes(){

        List<Bike> bikes = userService.getAllBikes();
        if (bikes.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars(){

        List<Car> cars = userService.getAllCars();
        if (cars.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(cars);

    }

    @PostMapping("/savecar/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable int userId,@RequestBody Car car){
        Car newCar = userService.saveCar(userId,car);
        return ResponseEntity.ok(newCar);
    }

    @PostMapping("/savebike/{userId}")
    public ResponseEntity<Bike> saveBike(@PathVariable int userId,@RequestBody Bike bike){
        Bike newBike = userService.saveBike(userId,bike);
        return ResponseEntity.ok(newBike);
    }
}
