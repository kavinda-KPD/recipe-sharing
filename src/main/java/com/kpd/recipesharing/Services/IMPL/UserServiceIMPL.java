package com.kpd.recipesharing.Services.IMPL;

import com.kpd.recipesharing.Config.JwtProvider;
import com.kpd.recipesharing.Models.User;
import com.kpd.recipesharing.Repositories.UserRepository;
import com.kpd.recipesharing.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> opt = userRepository.findById(userId);

        if (opt.isPresent()){
            return opt.get();
        }
        throw new Exception("user not found with this is "+ userId);
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {

        String email = jwtProvider.getEmailFromJwtToken(jwt);

        if (email == null){
            throw new Exception("provide valid token");
        }

        User user = userRepository.findByEmail(email);

        if (user==null){
            throw new Exception("user not found with email "+ email);
        }
        return user;
    }
}















