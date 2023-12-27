package com.kpd.recipesharing.Controllers;

import com.kpd.recipesharing.Models.User;
import com.kpd.recipesharing.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user) throws Exception{

        User isExists = userRepository.findByEmail(user.getEmail());
        if (isExists != null) {
            throw new Exception("user is exists with " + user.getEmail());
        }

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @DeleteMapping(path = "/users/{userID}")
    public String deleteUser(@PathVariable Long userID) throws Exception{

        userRepository.deleteById(userID);

        return "user Deleted Successfully";
    }

    @GetMapping(path = "/users")
    public List<User> getallUser() throws Exception{

        List<User> users = userRepository.findAll();

        return users;
    }


}
