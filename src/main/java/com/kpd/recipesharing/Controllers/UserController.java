package com.kpd.recipesharing.Controllers;

import com.kpd.recipesharing.Models.User;
import com.kpd.recipesharing.Repositories.UserRepository;
import com.kpd.recipesharing.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/api/users/profile")
    public User findUserByJWT(@RequestHeader("Authorization") String jwt)throws Exception{
        User user = userService.findUserByJwt(jwt);
        return user;
    }


}
