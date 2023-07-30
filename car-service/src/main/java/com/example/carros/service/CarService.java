package com.example.carros.service;

import com.example.carros.entity.Car;
import com.example.carros.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public Car getById(int id){
        return carRepository.findById(id).orElse(null);
    }

    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> findByUserId(int userId){
        return carRepository.findCarByUserId(userId);
    }


}
