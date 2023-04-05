/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Verduleria.service;

import com.Verduleria.Domain.Cargo;
import com.Verduleria.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class DetallesUsuarioServicio implements UserDetailsService {
    
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        com.Verduleria.Domain.User user = userDao.findByUsername(username);
        
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        
        var cargos = new ArrayList<GrantedAuthority>();
        
        for(Cargo cargo: user.getCargo()){
            cargos.add(new SimpleGrantedAuthority(cargo.getCargo()));
        }
        
        return new User(user.getUsername(),user.getPassword(),cargos);
    }
    
    
}
