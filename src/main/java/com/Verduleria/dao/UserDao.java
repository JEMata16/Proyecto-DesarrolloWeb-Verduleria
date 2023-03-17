package com.Verduleria.dao;

import com.Verduleria.Domain.User;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);
    User findByCargo(String cargo);
}

