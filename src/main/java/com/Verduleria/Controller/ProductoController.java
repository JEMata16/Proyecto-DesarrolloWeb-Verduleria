/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Verduleria.Controller;

import com.Verduleria.Domain.Producto;
import com.Verduleria.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/productos")
    public String inicial (Model model){
        var productos=productoService.obtenerProductos();
        model.addAttribute("productos", productos);
        return "/producto/productos";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Producto producto){
        return "/producto/agregar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("producto")Producto productoObject){
        productoService.addProducto(productoObject);
        return "redirect:/producto/productos";
    }
    
     @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto){
        productoService.deleteProducto(producto);
        return "redirect:/producto/productos";
    }
    
    @GetMapping("/editar/{idProducto}")
    public String editar(Producto producto, Model model){
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/editar";
    }
}
