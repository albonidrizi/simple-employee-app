package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.exception.ResourceNotFoundException;
import springboot.model.User;
import springboot.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get all employees
    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/user")
    public User createUsers(@RequestBody User user) {
        return userRepository.save(user);
    }

    // get employee by id rest api
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(user);
    }

    // update employee rest api
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable Long id, @RequestBody User UsersDetails){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        user.setFirstName(UsersDetails.getFirstName());
        user.setLastName(UsersDetails.getLastName());
        user.setEmailId(UsersDetails.getEmailId());

        User updatedEmployee = userRepository.save(user);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUsers(@PathVariable Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
