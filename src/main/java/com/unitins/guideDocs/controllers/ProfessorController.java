package com.unitins.guideDocs.controllers;

import com.unitins.guideDocs.models.Pessoa;
import com.unitins.guideDocs.models.Professor;
import com.unitins.guideDocs.repository.PessoaRepository;
import com.unitins.guideDocs.repository.ProfessorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProfessorController {

    private ProfessorRepository professorRepository;
    private PessoaRepository pessoaRepository;

    public ProfessorController(ProfessorRepository professorRepository,
                               PessoaRepository pessoaRepository) {
        this.professorRepository = professorRepository;
        this.pessoaRepository = pessoaRepository;
    }



    @RequestMapping("/avaliarProjeto")
    public String avaliarProjeto() {
        return "/professor/avaliarProjeto";
    }

    @RequestMapping("/definirDisponibilidade")
    public String definirDisponibilidade() {
        return "/professor/definirDisponibilidade";
    }

    @RequestMapping("/definirOrientador")
    public String definirOrientador() {
        return "/professor/definirOrientador";
    }

    @RequestMapping("/listarDocumentosAssinar")
    public String listarDocumentosAssinar() {
        return "/professor/listarDocumentosAssinar";
    }

    @RequestMapping("/selecaoBanca")
    public String selecaoBanca() {
        return "/professor/selecaoBanca";
    }

    @RequestMapping("/vincularOrientador")
    public String vincularOrientador() {
        return "/professor/vincularOrientador";
    }

    @RequestMapping("/submeterArquivo")
    public String submeterArquivos() {
        return "/professor/submeterArquivo";
    }

    @RequestMapping("/gerenciarOrientacoes")
    public String gerenciarOrientacoes() {
        return "/professor/gerenciarOrientacoes";
    }



}
