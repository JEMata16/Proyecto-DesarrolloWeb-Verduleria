
package com.Verduleria.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Usuarios")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String pass;
    private String cargo;

    public User() {
    }

    public User(Long id, String username, String pass, String cargo) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.cargo = cargo;
    }
 
}