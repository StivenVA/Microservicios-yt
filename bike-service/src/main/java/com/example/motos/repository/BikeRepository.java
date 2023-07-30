package com.example.motos.repository;

import com.example.motos.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Integer> {
    List<Bike> findCarByUserId(int userId);
}
