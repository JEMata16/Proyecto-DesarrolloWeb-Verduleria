/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Verduleria.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ventas")
public class Cajas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCajas;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    private int cantidadComprada;
    private double totalCompra;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Cajas() {
    }

    public Cajas(String nombreCliente, int cantidadComprada, double totalCompra) {
        this.nombreCliente = nombreCliente;
        this.cantidadComprada = cantidadComprada;
        this.totalCompra = totalCompra;
    }

    public Cajas(String nombreCliente, int cantidadComprada, double totalCompra, Long producto) {
        this.nombreCliente = nombreCliente;
        this.cantidadComprada = cantidadComprada;
        this.totalCompra = totalCompra;
        this.producto.setIdProducto(producto);
    }
    
    

    public Long getId() {
        return idCajas;
    }

    public void setId(Long id) {
        this.idCajas = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
