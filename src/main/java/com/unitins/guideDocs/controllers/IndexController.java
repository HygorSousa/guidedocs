package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/cadastroprof")
    public String cadastrarProfessor(){
        return "cadastro_prof";
    }
    
    @RequestMapping("/listaprof")
    public String listarProfessor(){
        return "lista_prof";
    }
}
