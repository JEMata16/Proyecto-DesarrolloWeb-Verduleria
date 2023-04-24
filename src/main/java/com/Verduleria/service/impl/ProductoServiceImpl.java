/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Verduleria.service.impl;

import com.Verduleria.service.ProductoService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Verduleria.Domain.Producto;
import com.Verduleria.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public void addProducto(Producto producto) {
       productoDao.save(producto);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return productoDao.findAll();
    }

    @Override
    public void deleteProducto(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

}
