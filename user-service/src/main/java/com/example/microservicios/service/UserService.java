package com.example.microservicios.service;

import com.example.microservicios.entity.User;
import com.example.microservicios.feignclients.BikeFeignClient;
import com.example.microservicios.feignclients.CarFeignClient;
import com.example.microservicios.model.Bike;
import com.example.microservicios.model.Car;
import com.example.microservicios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final CarFeignClient carClient;
    private final BikeFeignClient bikeFeignClient;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public Car saveCar(int userId,Car car){

        car.setUserId(userId);
        return carClient.save(car);
    }

    public Bike saveBike(int userId,Bike bike){
        bike.setUserId(userId);
        return bikeFeignClient.save(bike);
    }

    public List<Car> getAllCars(){
        return carClient.getAll();
    }

    public List<Car> getCarsById(int userId){
        return carClient.getById(userId);
    }

    public List<Bike> getAllBikes(){
        return bikeFeignClient.getAll();
    }

    public List<Bike> getBikesById(int userId){
        return bikeFeignClient.getById(userId);
    }

}
