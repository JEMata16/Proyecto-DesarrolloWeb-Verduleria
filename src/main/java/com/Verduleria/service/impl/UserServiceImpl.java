package com.Verduleria.service.impl;

import com.Verduleria.Domain.User;
import com.Verduleria.dao.UserDao;
import com.Verduleria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userDataBase;
    

    @Override
    public void addUser(User user) {
        user.setCargo("USER");
        userDataBase.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDataBase.findByUsername(username);
    }

}