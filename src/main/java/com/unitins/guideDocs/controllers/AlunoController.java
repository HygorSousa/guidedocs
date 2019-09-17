package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {

    
    @RequestMapping("/selecaobanca")
    public String selecaobanca() {
        return "/aluno/selecaoBanca";
    }

    @RequestMapping("/submeterArquivo")
    public String submeterArquivos() {
        return "/aluno/submeterArquivo";
    }
}
