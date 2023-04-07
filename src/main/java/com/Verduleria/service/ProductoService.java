/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Verduleria.service;

import java.util.List;
import com.Verduleria.Domain.Producto;

public interface ProductoService {
    public void addProducto();
    
    public List<Producto> obtenerProductos();
}
