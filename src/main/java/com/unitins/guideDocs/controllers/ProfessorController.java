package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

    @RequestMapping("/cadastrarProfessor")
    public String cadastrarProfessor() {
        return "cadastrarProfessor";
    }

    @RequestMapping("/listarProfessor")
    public String listarProfessor() {
        return "listarProfessor";
    }

    @RequestMapping("/excluirAluno")
    public String excluirAluno() {
        return "excluirAluno";
    }
    
    @RequestMapping("/upprojet")
    public String encaminharProjeto() {
        return "uploadProjeto";
    }

}
