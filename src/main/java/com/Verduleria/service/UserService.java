/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Verduleria.service;

import com.Verduleria.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserService  {
    public User encontrarPorEmail(String email);
}
