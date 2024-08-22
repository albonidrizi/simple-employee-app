package org.sty.springboot_be.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.sty.springboot_be.exception.ResourceNotFoundException;
import org.sty.springboot_be.model.User;
import org.sty.springboot_be.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<User> getUsersById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUsers(User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<User> updateUsers(Long id, User UsersDetails){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        user.setFirstName(UsersDetails.getFirstName());
        user.setLastName(UsersDetails.getLastName());
        user.setEmailId(UsersDetails.getEmailId());

        User updatedEmployee = userRepository.save(user);
        return ResponseEntity.ok(updatedEmployee);
    }

    public void deleteUsers(Long id){
        userRepository.deleteById(id);
    }

}
