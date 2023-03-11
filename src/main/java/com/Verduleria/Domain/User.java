
package com.Verduleria.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Empleado")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String pass;
    private String nombre;
    private String apellido;
    private String contacto;
    private int salario;
    private char cargo; //A = Administrador / E = Empleado

    public User() {
    }

    public User(Long id, String email, String pass, String nombre, String apellido, String contacto, int salario, char cargo) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
        this.salario = salario;
        this.cargo = cargo;
    }

    
    
    
}
