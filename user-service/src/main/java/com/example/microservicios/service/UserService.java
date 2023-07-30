package com.example.microservicios.service;

import com.example.microservicios.entity.User;
import com.example.microservicios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        return userRepository.save(user);
    }

}
