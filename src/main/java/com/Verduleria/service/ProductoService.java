/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Verduleria.service;

import java.util.List;
import com.Verduleria.Domain.Producto;

public interface ProductoService {
    public void addProducto(Producto producto);
    
    public List<Producto> obtenerProductos();
    
    public void deleteProducto(Producto producto);
    
    public Producto getProducto(Producto producto);
    
    public String getProductoById(Long producto);
    
    public Long loadByNombre(String producto);
}
