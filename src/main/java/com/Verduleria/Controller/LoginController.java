
package com.Verduleria.Controller;

import com.Verduleria.Domain.User;
import com.Verduleria.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @Autowired
    private UserDao userDao;
    
    @GetMapping("/")
    public String showLoginPage(){
        return "login";
    }
    
    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("usuario",new User());
        return "register";
    }
    
    @PostMapping("/procesar-registro")
    public String procesarRegistro(User user){
        userDao.save(user);
        return "login";
    }
}
