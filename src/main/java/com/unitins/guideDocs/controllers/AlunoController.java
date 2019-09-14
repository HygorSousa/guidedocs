package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {
    @RequestMapping("/cadastrarAluno")
    public String cadastrarAluno() {
        return "cadastrarAluno";
    }

    @RequestMapping("/editarAluno")
    public String editarAluno() {
        return "editarAluno";
    }

    @RequestMapping("/listarAluno")
    public String listarAluno() {
        return "listarAluno";
    }
    
    @RequestMapping("/selecaobanca")
    public String selecaobanca() {
        return "selecaoBanca";
    }

    @RequestMapping("/submeterArquivo")
    public String submeterArquivos() {
        return "submeterArquivo";
    }
}
