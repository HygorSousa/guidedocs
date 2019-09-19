package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

	@RequestMapping("/criarTurma")
	public String criarTurma() {
		return "/professor/criarTurma";
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
