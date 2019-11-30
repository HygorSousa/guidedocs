package com.unitins.guideDocs.controllers;

import org.springframework.stereotype.Controller;

import com.unitins.guideDocs.models.Disponibilidade;

@Controller
public class DefinirDisponibilidadeController {
	Disponibilidade disponibilidade = new Disponibilidade();
	
	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}
	
	private void set() {
		// TODO Auto-generated method stub

	}
	
}
