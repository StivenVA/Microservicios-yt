package com.example.motos.controller;

import com.example.motos.entity.Bike;
import com.example.motos.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "bike")
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAll(){

        List<Bike> bikes = bikeService.getAll();

        if (bikes.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(bikes);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Bike> getById(@PathVariable int id){

        Bike bike = bikeService.getById(id);

        if (bike==null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(bike);
    }

    @PostMapping
    public ResponseEntity<Bike> save(@RequestBody Bike bike){

        Bike bikeNew = bikeService.save(bike);

        return ResponseEntity.ok(bikeNew);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable int userId){

        List<Bike> bikes = bikeService.findByUserId(userId);

        if(bikes.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(bikes);
    }

}
