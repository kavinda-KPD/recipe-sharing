package com.kpd.recipesharing.Repositories;

import com.kpd.recipesharing.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
