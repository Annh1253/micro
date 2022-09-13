package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        userRepository.insert(user);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public void updateUser(User user){
        User savedUser = userRepository.findById(user.getId())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find User by ID %s", user.getId())
                ));
        savedUser.setName(user.getName());
        userRepository.save(user);
    }

    public User getUserByName(String name){
        return userRepository.findByName(name)
                .orElseThrow(
                        ()-> new RuntimeException(String.format("Cannot find user with Name: %s", name))
                );
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

}
