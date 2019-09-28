package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/cadastrarAluno")
	public String cadastrarAluno() {
		return "/admin/cadastrarAluno";
	}

	@RequestMapping("/editarAluno")
	public String editarAluno() {
		return "/admin/editarAluno";
	}

	@RequestMapping("/listarAluno")
	public String listarAluno() {
		return "/admin/listarAluno";
	}

	@RequestMapping("/excluirAluno")
	public String excluirAluno() {
		return "/admin/excluirAluno";
	}

	@RequestMapping("/cadastrarProfessor")
	public String cadastrarProfessor() {
		return "/admin/cadastrarProfessor";
	}

	@RequestMapping("/editarProfessor")
	public String editarProfessor() {
		return "/admin/editarProfessor";
	}

	@RequestMapping("/listarProfessor")
	public String listarProfessor() {
		return "/admin/listarProfessor";
	}

	@RequestMapping("/excluirProfessor")
	public String excluirProfessor() {
		return "/admin/excluirProfessor";
	}
}
