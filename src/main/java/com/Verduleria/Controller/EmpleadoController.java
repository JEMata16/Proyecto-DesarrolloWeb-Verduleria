package com.Verduleria.Controller;

import com.Verduleria.Domain.Empleado;
import com.Verduleria.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    
   @GetMapping("/empleados")
    public String inicio(Model model){
        var empleados=empleadoService.getEmpleados();
        model.addAttribute("empleados", empleados);
        return "/empleado/empleados";
    }  
    @GetMapping("/eliminar/{idEmpleado}")
    public String eliminar(Empleado empleado){
        empleadoService.deleteEmpleado(empleado);
        return "redirect:/empleado/empleados";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Empleado empleado){
        return "/empleado/editar";
    }
    // Si el metodo del text imput es post, se debe usar post mapping
    @PostMapping("/guardar")
    public String guardar(Empleado empleado){
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleado/empleados";
    }
    
     @GetMapping("/editar/{idEmpleado}")
    public String editar(Empleado empleado, Model model){
        empleado = empleadoService.getEmpleado(empleado);
        model.addAttribute("empleado", empleado);
        return "/empleado/editar";
    }
}
