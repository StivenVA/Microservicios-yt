package com.example.motos.service;


import com.example.motos.entity.Bike;
import com.example.motos.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeService {

    private final BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.findAll();
    }

    public Bike getById(int id){
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike save(Bike bike){
        return bikeRepository.save(bike);
    }

    public List<Bike> findByUserId(int userId){
        return bikeRepository.findCarByUserId(userId);
    }


}
