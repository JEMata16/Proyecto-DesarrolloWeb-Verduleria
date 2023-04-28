/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Verduleria.service.impl;

import com.Verduleria.Domain.Cajas;
import com.Verduleria.dao.CajasDao;
import com.Verduleria.service.CajasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CajasServiceImpl implements CajasService{
    
    @Autowired
    private CajasDao cajasDao;
    
    @Override
    public List<Cajas> getLista() {
        return listaCajas;
    }
    
    @Override
    public void addCajas(Cajas cajas) {
       cajasDao.save(cajas);
    }

    @Override
    public List<Cajas> obtenerCajas() {
        return cajasDao.findAll();
    }

    
    @Override
    public Cajas getCajas(Cajas cajas) {
        return cajasDao.findById(cajas.getIdCajas()).orElse(null);
    }

    

    @Override
    public String totalVendido() {
        int total = 0;
        for (Cajas i : listaCajas) {
            total += i.getProducto().getPrecio()* i.getCantidadComprada();
        }
        listaCajas.clear();
        return String.valueOf(total);
    }
    
}
