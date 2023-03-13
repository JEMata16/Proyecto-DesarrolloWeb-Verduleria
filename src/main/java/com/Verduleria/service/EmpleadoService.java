package com.Verduleria.service;

import com.Verduleria.Domain.Empleado;
import java.util.List;

public interface EmpleadoService {

    public List<Empleado> getEmpleados();

    public Empleado getEmpleado(Empleado empleado);

    public void deleteEmpleado(Empleado empleado);

    public void saveEmpleado(Empleado empleado);
}
