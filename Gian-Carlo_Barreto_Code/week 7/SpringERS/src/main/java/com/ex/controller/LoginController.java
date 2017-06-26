package com.ex.controller;

//import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.beans.Employee;
import com.ex.service.Service;

@Controller
public class LoginController {
    
    @Autowired
    private Service service;
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLoginPage(ModelMap modelMap){
        System.out.println("GET login");
        
        Employee emptyEmployee = new Employee();
        modelMap.addAttribute("user", emptyEmployee);
        
        return "login";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String doLogin(@Valid Employee employee, BindingResult bindingResult, ModelMap modelMap){
        
        System.out.println("POST login");
        
        if(bindingResult.hasErrors()){
            //ASSERT: validation failed
            return "login";
        }
        //ASSERT: validation successful
        
        System.out.println(employee);
        Employee authUser = service.auth(employee);
        
        if(authUser != null){
            //ASSERT: authentication successful
            return "redirect:home";
        }else {
            //ASSERT: authentication failed
            modelMap.addAttribute("errorMessage", "Username/Password incorrect");
            return "login";    
        }   
    }
}