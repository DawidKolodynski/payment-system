package com.dawid.paymentsystem.ui;

import com.dawid.paymentsystem.model.User;
import com.dawid.paymentsystem.model.UserRepository;
import com.dawid.paymentsystem.ui.requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private UserRepository userRepository;

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/users/")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/users")
    public void addUser(@RequestBody AddUserRequest cmd) {
        User user = new User();
        user.setFirstName(cmd.getFirstName());
        user.setLastName(cmd.getLastName());
        user.setEmail(cmd.getEmail());
        user.setPassword(cmd.getPassword());
        userRepository.save(user);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        System.out.println("Updating user " + id);
        User currentUser = userRepository.findById(id);

        if (currentUser == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        if (user.getFirstName() != null)
            currentUser.setFirstName(user.getFirstName());
        if (user.getLastName() != null)
            currentUser.setLastName(user.getLastName());
        if (user.getEmail() != null)
            currentUser.setEmail(user.getEmail());
        if (user.getPassword() != null)
            currentUser.setPassword(user.getPassword());

        userRepository.save(currentUser);

        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }


}
