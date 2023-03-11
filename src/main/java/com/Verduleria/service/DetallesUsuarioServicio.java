/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Verduleria.service;

import com.Verduleria.Domain.User;
import com.Verduleria.dao.UserDao;
import com.Verduleria.security.DetallesUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DetallesUsuarioServicio implements UserDetailsService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        
        if(user == null){
            throw new UsernameNotFoundException("No se encontro usuario");
        }
        
        return new DetallesUsuario(user);
    }
    //Funciona
}
