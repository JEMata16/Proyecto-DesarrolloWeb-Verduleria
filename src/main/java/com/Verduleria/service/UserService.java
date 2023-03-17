package com.Verduleria.service;

import com.Verduleria.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserService  {
    public void addUser(User user);

    public User findByUsername(String username);
}
