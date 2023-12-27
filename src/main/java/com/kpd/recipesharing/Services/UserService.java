package com.kpd.recipesharing.Services;

import com.kpd.recipesharing.Models.User;

public interface UserService {

    public User findUserById(Long userId) throws Exception;
}
