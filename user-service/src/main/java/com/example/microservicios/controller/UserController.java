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

}
