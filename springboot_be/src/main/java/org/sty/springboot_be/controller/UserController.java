package org.sty.springboot_be.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sty.springboot_be.exception.ResourceNotFoundException;
import org.sty.springboot_be.model.User;
import org.sty.springboot_be.repository.UserRepository;
import org.sty.springboot_be.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService service;

    // get all employees
    @GetMapping("/user")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    // create employee rest api
    @PostMapping("/user")
    public User createUsers(@RequestBody User user) {
        return service.createUsers(user);
    }

    // get employee by id rest api
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable Long id) {
        return service.getUsersById(id);
    }

    // update employee rest api
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable Long id, @RequestBody User UsersDetails){
        return service.updateUsers(id, UsersDetails);
    }

    // delete employee rest api
    @DeleteMapping("/user/{id}")
    public void deleteUsers(@PathVariable Long id){
        service.deleteUsers(id);
    }

}
