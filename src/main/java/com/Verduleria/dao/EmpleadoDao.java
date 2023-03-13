package com.Verduleria.dao;

import com.Verduleria.Domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoDao extends JpaRepository<Empleado, Long>{
    
}
