
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
    public User encontrarPorEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}