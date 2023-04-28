/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Verduleria.service;

import com.Verduleria.Domain.Cajas;
import com.Verduleria.Domain.Producto;
import java.util.ArrayList;
import java.util.List;

public interface CajasService {

    List<Cajas> listaCajas = new ArrayList<>();

    public void addCajas(Cajas cajas);

    public List<Cajas> obtenerCajas();

    public Cajas getCajas(Cajas cajas);

    public List<Cajas> getLista();

    public String totalVendido();
}
