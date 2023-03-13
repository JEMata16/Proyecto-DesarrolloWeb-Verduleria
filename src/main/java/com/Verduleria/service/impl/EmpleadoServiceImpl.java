package com.Verduleria.service.impl;

import com.Verduleria.Domain.Empleado;
import com.Verduleria.dao.EmpleadoDao;
import com.Verduleria.service.EmpleadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired
    private EmpleadoDao empleadoDao;
    @Override
    public List<Empleado> getEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    public Empleado getEmpleado(Empleado empleado) {
        return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
        empleadoDao.save(empleado);
    }
    
}
