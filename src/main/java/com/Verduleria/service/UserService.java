/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Verduleria.service;

import com.Verduleria.Domain.User;

public interface UserService {
    public void addUser(User user);

    public User findByUsername(String username);
}
