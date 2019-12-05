package com.unitins.guideDocs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unitins.guideDocs.models.Disponibilidade;
import com.unitins.guideDocs.models.Professor;
import com.unitins.guideDocs.repository.DefinirDisponibilidadeRepository;
import com.unitins.guideDocs.repository.PessoaRepository;

@Controller
public class DefinirDisponibilidadeController {
	
	@Autowired
	private DefinirDisponibilidadeRepository disponibilidadeDb;
	
	@Autowired
	private PessoaRepository pessoaDb;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addDisponibilidade")
	public String addDisponibilidade(Disponibilidade disponibilidade) {
		Authentication usuarioSessao = SecurityContextHolder.getContext().getAuthentication();
		String login = usuarioSessao.getName();
		Professor professor = (Professor) pessoaDb.findByCpf(login);
	
		disponibilidade.setProfessor(professor);
		
		disponibilidadeDb.save(disponibilidade);
		
		return "redirect:/definirDisponibilidade";
	}
	
	@RequestMapping(method = RequestMethod.GET ,value = "/definirDisponibilidade")
	public ModelAndView listarDisponibilidades() {
		ModelAndView mv = new ModelAndView("/professor/definirDisponibilidade");
		Iterable<Disponibilidade> disponibilidades = disponibilidadeDb.findAll();
		mv.addObject("disponibilidades", disponibilidades);
		return mv;
	}
	
	@RequestMapping("/deletarDisponibilidade")
	public String deletarDisponibilidade(Disponibilidade disponibilidade) {
		
		disponibilidadeDb.delete(disponibilidade);
		return "redirect:/definirDisponibilidade";
	}
}
