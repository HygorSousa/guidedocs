package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {



    @RequestMapping("/upprojet")
    public String encaminharProjeto() {
        return "uploadProjeto";
    }

    @RequestMapping("/avaliarProjeto")
    public String avaliarProjeto() {
        return "avaliarProjeto";
    }

    @RequestMapping("/criarTurma")
    public String criarTurma() {
        return "criarTurma";
    }

    @RequestMapping("/definirDisponibilidade")
    public String definirDisponibilidade() {
        return "definirDisponibilidade";
    }

    @RequestMapping("/vincularOrientador")
    public String vincularOrientador() {
        return "vincularOrientador";
    }

    @RequestMapping("/aprovarProtocolo")
    public String aprovarProtocolo() {
        return "aprovarProtocolo";
    }

    @RequestMapping("/definirOrientador")
    public String definirOrientador() {
        return "definirOrientador";
    }
}
