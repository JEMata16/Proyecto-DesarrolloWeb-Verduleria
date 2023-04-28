/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Verduleria.Controller;

import com.Verduleria.Domain.Cajas;
import com.Verduleria.Domain.Producto;
import com.Verduleria.service.CajasService;
import com.Verduleria.service.ProductoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ventas")
public class CajasController {

    ArrayList<Cajas> facturasR = new ArrayList<>();

    @Autowired
    private CajasService cajasService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/cajas")
    public String inicial(Model model) {
        var cajas = cajasService.obtenerCajas();
        model.addAttribute("cajas", cajas);

        var listaCajas = cajasService.obtenerCajas();
        Map<String, List<Cajas>> groupedByCliente = listaCajas.stream().collect(Collectors.groupingBy(Cajas::getNombreCliente));

        var carritoTotalVenta = 0;
        for (Cajas caja : cajas) {
            carritoTotalVenta += (caja.getCantidadComprada() * caja.getProducto().getPrecio());
        }

        Map<String, String> productosPorCliente = new HashMap<>();
        for (Map.Entry<String, List<Cajas>> entry : groupedByCliente.entrySet()) {
            List<Cajas> cajasCliente = entry.getValue();
            String productosComprados = cajasCliente.stream()
                    .map(caja -> caja.getProducto().getNombre())
                    .collect(Collectors.joining(","));
            productosPorCliente.put(entry.getKey(), productosComprados);
        }

        System.out.println(productosPorCliente);
        model.addAttribute("productosPorCliente", productosPorCliente);

        Map<String, String> cantidadPorCliente = new HashMap<>();
        for (Map.Entry<String, List<Cajas>> entry : groupedByCliente.entrySet()) {
            List<Cajas> cajasCliente = entry.getValue();
            String cantidadesCompradas = cajasCliente.stream()
                    .map(caja -> String.valueOf(caja.getCantidadComprada()))
                    .collect(Collectors.joining(","));
            cantidadPorCliente.put(entry.getKey(), cantidadesCompradas);
        }

        System.out.println(cantidadPorCliente);
        model.addAttribute("cantidadPorCliente", cantidadPorCliente);
        

        Map<String, Double> totalComprasPorCliente = new HashMap<>();

        for (Map.Entry<String, List<Cajas>> entry : groupedByCliente.entrySet()) {
            List<Cajas> cajasCliente = entry.getValue();
            double totalCompra = (double) cajasCliente.stream()
                    .mapToDouble(caja -> caja.getCantidadComprada() * caja.getProducto().getPrecio())
                    .sum();
            totalComprasPorCliente.put(entry.getKey(), totalCompra);
        }
        System.out.println(totalComprasPorCliente);
        
        model.addAttribute("totalComprasPorCliente",totalComprasPorCliente);
        model.addAttribute("totalCajas", carritoTotalVenta);
        return "/ventas/cajas";

    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("cajas") Cajas cajaObject) {
        if (!facturasR.isEmpty()) {
            System.out.println("1");
            for (Cajas i : facturasR) {
                Long idProducto = productoService.loadByNombre(cajaObject.getProducto().getNombre());
                cajaObject.getProducto().setIdProducto(idProducto);
            }
            cajasService.addCajas(cajaObject);
        } else {
            System.out.println("2");
            Long idProducto = productoService.loadByNombre(cajaObject.getProducto().getNombre());
            cajaObject.getProducto().setIdProducto(idProducto);
            cajasService.addCajas(cajaObject);
        }
        return "redirect:/ventas/nuevo";
    }

    @PostMapping("/registrar")
    public String productoAlmacenado(@RequestParam("nombreCliente") String nombreCliente,
                                 @RequestParam("productoNombre") String productoNombre,
                                 @RequestParam("cantidadComprada") int cantidadComprada) {
        Long idProducto = productoService.loadByNombre(productoNombre);
        Cajas cajas = new Cajas(nombreCliente,cantidadComprada, 0, idProducto);
        System.out.println(cajas);
        return "redirect:/ventas/nuevo";
    }
    
    
    @GetMapping("/nuevo")
    public String nuevoCajas(Cajas cajas){
        return "/ventas/agregar";
    }
}
