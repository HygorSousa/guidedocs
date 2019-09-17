package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {
    @RequestMapping("/aprovarProtocolo")
    public String aprovarProtocolo() { return "/aluno/aprovarProtocolo"; }

    @RequestMapping("/avaliarProjeto")
    public String avaliarProjeto() {
        return "/aluno/avaliarProjeto";
    }

    @RequestMapping("/uploadProjeto")
    public String encaminharProjeto() {
        return "/aluno/uploadProjeto";
    }

}
