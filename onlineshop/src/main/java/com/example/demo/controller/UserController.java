package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    public void findUser(){}

    @GetMapping("/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    public ResponseEntity updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
