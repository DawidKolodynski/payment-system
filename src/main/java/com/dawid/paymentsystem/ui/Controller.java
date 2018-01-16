package com.dawid.paymentsystem.ui;

import com.dawid.paymentsystem.model.User;
import com.dawid.paymentsystem.model.UserRepository;
import com.dawid.paymentsystem.ui.requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private UserRepository userRepository;

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/users/{id}")
    public List<User> findUser(@PathVariable Integer id) {
        return userRepository.findById(id);

    }

    @PutMapping("/users")
    public void addUser(@RequestBody AddUserRequest cmd) {
        User user = new User();
        user.setFirstName(cmd.getFirstName());
        user.setLastName(cmd.getLastName());
        user.setEmail(cmd.getEmail());
        user.setPassword(cmd.getPassword());
        userRepository.save(user);
    }

    //TODO: nie działa
//    @PutMapping("/users/{id}")
//    public void updateUser(@PathVariable Integer id, @RequestBody AddUserRequest cmd) {
//        User user = userRepository.get(cmd.getId());
//        user.updateEmail(cmd.getEmail());
//        userRepository.save(user);
//    }


}
