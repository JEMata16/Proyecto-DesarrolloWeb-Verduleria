package com.Verduleria.Controller;

import com.Verduleria.Domain.User;
import com.Verduleria.dao.UserDao;
import com.Verduleria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @Autowired
    private UserService service;
    
    @GetMapping("/")
    public String showLoginPage(){
        return "login";
    }
    
    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("usuario",new User());
        return "register";
        
    }
    
    @PostMapping("/register/save")
    public String procesarRegistro(@ModelAttribute("User")User user, BindingResult result,Model model){
        User existingUsers = service.findByUsername(user.getUsername());
        
        if(existingUsers != null && existingUsers.getUsername() != null && !existingUsers.getUsername().isEmpty()){
            result.rejectValue("username", "Usuario existente");
        }
        if(result.hasErrors()){
            model.addAttribute("usuario", user);
            return "register";
        }
        service.addUser(user);
        return "redirect:/?success";
    }
    
    @GetMapping("/inicio")
    public String home(){
        return "redirect:/homePage";
    }
}
