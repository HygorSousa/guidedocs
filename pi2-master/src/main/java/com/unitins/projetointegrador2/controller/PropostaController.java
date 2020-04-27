package com.unitins.projetointegrador2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.model.Proposta;
import com.unitins.projetointegrador2.model.STATUS;
import com.unitins.projetointegrador2.model.TIPO;
import com.unitins.projetointegrador2.service.AlunoService;
import com.unitins.projetointegrador2.service.ProfessorService;
import com.unitins.projetointegrador2.service.PropostaService;

@Controller
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService service;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/cadastrar")
    public String cadastrar(Proposta Proposta) {
        return "/proposta/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("propostas", service.buscarTodos());
        return "/proposta/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Proposta proposta, RedirectAttributes attr) {
        service.salvar(proposta);
        attr.addFlashAttribute("success", "Proposta inserido com sucesso.");
        return "redirect:/proposta/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("proposta", service.buscarPorId(id));
        return "/proposta/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Proposta proposta, RedirectAttributes attr) {
        service.editar(proposta);
        attr.addFlashAttribute("success", "Proposta editado com sucesso.");
        return "redirect:/proposta/cadastrar";
    }

    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
        model.addAttribute("propostas", service.buscarPorTitulo(nome));
        return "/proposta/lista";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
        service.excluir(id);
        attr.addFlashAttribute("success", "Proposta removida com sucesso.");
        return "redirect:/proposta/listar";
    }
    
    @GetMapping("/buscar/aluno")
	public String getPorAluno(@RequestParam("aluno") String nome, ModelMap model) {
		model.addAttribute("propostas", service.buscarPorAluno(nome));
		return "/proposta/lista";
	}
	
	@GetMapping("/buscar/professor")
	public String getPorProfessor(@RequestParam("professor") String nome, ModelMap model) {
		model.addAttribute("propostas", service.buscarPorProfessor(nome));
		return "/proposta/lista";
	}

    @ModelAttribute("professores")
    public List<Professor> listaDeProfessores(){
        return professorService.buscarTodos();
    }

    @ModelAttribute("alunos")
    public List<Aluno> listaDeAlunos(){
        return alunoService.buscarTodos();
    }

    @ModelAttribute("tipos")
    public TIPO[] getTipos(){
        return TIPO.values();
    }

    @ModelAttribute("status")
    public STATUS[] getStatus(){
        return STATUS.values();
    }

}
