package com.Verduleria.dao;

import com.Verduleria.Domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByUsername(String username);
    User findByCargo(String cargo);
}

