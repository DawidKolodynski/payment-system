package com.dawid.paymentsystem.ui;

import com.dawid.paymentsystem.acceptance.CommandGateway;
import com.dawid.paymentsystem.model.User;
import com.dawid.paymentsystem.model.UserRepository;
import com.dawid.paymentsystem.model.commands.CreateUserCommand;
import com.dawid.paymentsystem.ui.requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private CommandGateway commandGateway;

    public UserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

//    @GetMapping("/users/{id}")
//    public User findUser(@PathVariable Integer id) {
//        return userRepository.findById(id);
//    }

//    @GetMapping("/users/")
//    public List<User> findAllUsers() {
//        return userRepository.findAll();
//    }


    @PostMapping("/users")
    public void createUser(@RequestBody CreateUserCommand cmd) {
        commandGateway.execute(cmd);
    }


//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
//        System.out.println("Updating user " + id);
//        User currentUser = userRepository.findById(id);
//
//        if (currentUser == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//        if (user.getFirstName() != null)
//            currentUser.setFirstName(user.getFirstName());
//        if (user.getLastName() != null)
//            currentUser.setLastName(user.getLastName());
//        if (user.getEmail() != null)
//            currentUser.setEmail(user.getEmail());
//        if (user.getPassword() != null)
//            currentUser.setPassword(user.getPassword());
//
//        userRepository.save(currentUser);
//
//        return new ResponseEntity<>(currentUser, HttpStatus.OK);
//    }


}
