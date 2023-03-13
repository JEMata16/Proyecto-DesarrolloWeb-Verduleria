package com.Verduleria.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEmpleado;
    
    private String nombre;
    private String apellidos;
    private String contacto;
    private int salario;

    public Empleado() {
    }

    public Empleado(Long idEmpleado, String nombre, String apellidos, String contacto, int salario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contacto = contacto;
        this.salario = salario;
    }
    
}
