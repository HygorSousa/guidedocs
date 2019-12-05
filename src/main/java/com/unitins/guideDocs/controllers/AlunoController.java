package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {
    @RequestMapping("/cadastrarOrientacao")
    public String cadastrarOrientacao() { return "/aluno/cadastrarOrientacao"; }

    @RequestMapping("/uploadProjeto")
    public String encaminharProjeto() {
        return "/aluno/uploadProjeto";
    }

}
