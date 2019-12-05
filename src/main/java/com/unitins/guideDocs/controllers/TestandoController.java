package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestandoController {

    @RequestMapping("/logado")
    public String logado(){
        return "logado";
    }


    @RequestMapping("/listar_documentos_assinar")
    public String listadocs() {
        return "listar_documentos_assinar";
    }
}
