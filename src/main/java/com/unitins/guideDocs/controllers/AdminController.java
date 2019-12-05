package com.unitins.guideDocs.controllers;

import com.unitins.guideDocs.models.*;
import com.unitins.guideDocs.repository.*;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private ProfessorRepository professorRepository;
    private PessoaRepository pessoaRepository;
    private TurmaRepository turmaRepository;
    private AlunoRepository alunoRepository;
    private CursoRepository cursoRepository;
    private AreaConhecimentoRepository areaConhecimentoRepository;
    private DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    public AdminController(ProfessorRepository professorRepository,
                           PessoaRepository pessoaRepository,
                           TurmaRepository turmaRepository,
                           AlunoRepository alunoRepository,
                           CursoRepository cursoRepository,
                           AreaConhecimentoRepository areaConhecimentoRepository,
                           DisponibilidadeRepository disponibilidadeRepository) {
        this.professorRepository = professorRepository;
        this.pessoaRepository = pessoaRepository;
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
        this.areaConhecimentoRepository = areaConhecimentoRepository;
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    @RequestMapping("/criarTurma")
    public String criarTurma() {
        return "/professor/criarTurma";
    }


    @PostMapping("/salvarTurma")
    public String salvarTurma(@Valid Turma turma, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/criarTurma";
        }
        turmaRepository.save(turma);
        model.addAttribute("professores", pessoaRepository.findAll());
        return "redirect:/listarProfessor";
    }

    @RequestMapping("/cadastrarAluno")
    public String cadastrarAluno(Model model) {
        model.addAttribute("cursos", cursoRepository.findAll());
        return "/admin/cadastrarAluno";
    }

    @PostMapping("/salvarAluno")
    public String salvarAluno(@Valid Aluno aluno, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/cadastrarAluno";
        }
        alunoRepository.save(aluno);
        model.addAttribute("alunos", alunoRepository.findAll());
        return "redirect:/listarAluno";
    }

    @RequestMapping("/editarAluno/{id}")
    public String editarAluno(@PathVariable Integer id, Model model) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não foi possível encontrar esse Professor"));
        model.addAttribute("aluno", aluno);
        return "redirect:/cadastrarAluno";
    }

    @RequestMapping("/listarAluno")
    public String listarAluno(Model model) {
        List<Aluno> alunos = alunoRepository.findAll();
        model.addAttribute("alunos", alunos);
        return "/admin/listarAluno";
    }

    @RequestMapping("/excluirAluno/{id}")
    public String excluirAluno(@PathVariable Integer id, Model model) {
        try {
            alunoRepository.deleteById(id);
            model.addAttribute("alunos", alunoRepository.findAll());
        } catch (ConstraintViolationException constraintViolationException) {
            model.addAttribute("erroAoExcluir", true);
        }
        return "redirect:/listarAluno";
    }

    @RequestMapping("/cadastrarProfessor")
    public String cadastrarProfessor(Model model) {
        model.addAttribute("areasConhecimento", areaConhecimentoRepository.findAll());
        model.addAttribute("disponibilidades", disponibilidadeRepository.findAll());
        return "/admin/cadastrarProfessor";
    }

    @RequestMapping("/listarProfessor")
    @PreAuthorize("hasRole('ADMIN')")
    public String listarProfessor(Model model) {
        List<Professor> professors = professorRepository.findAll();
        model.addAttribute("professores", professors);
        return "/admin/listarProfessor";
    }

    @PostMapping("/salvarProfessor")
    public String salvarProfessor(@Valid Professor professor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/cadastroProfessor";
        }
        pessoaRepository.save(professor);
        model.addAttribute("professores", pessoaRepository.findAll());
        return "redirect:/listarProfessor";
    }

    @RequestMapping("/excluirProfessor/{id}")
    public String excluirProfessor(@PathVariable Integer id, Model model) {
        try {
            pessoaRepository.deleteById(id);
            model.addAttribute("professores", pessoaRepository.findAll());
        } catch (ConstraintViolationException constraintViolationException) {
            model.addAttribute("erroAoExcluir", true);
        }
        return "redirect:/listarProfessor";
    }

    @RequestMapping("/editarProfessor/{id}")
    public String editarProfessor(@PathVariable Integer id, Model model) {
        Pessoa professor = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não foi possível encontrar esse Professor"));
        model.addAttribute("professor", professor);
        model.addAttribute("areasConhecimento", areaConhecimentoRepository.findAll());
        model.addAttribute("disponibilidades", disponibilidadeRepository.findAll());
        return "redirect:/cadastrarProfessor";
    }

    @RequestMapping("/cadastrarCurso")
    public String cadastrarCurso() {
        return "/admin/cadastrarCurso";
    }

    @RequestMapping("/listarCurso")
    public String listarCurso(Model model) {
        List<Curso> cursos = cursoRepository.findAll();
        model.addAttribute("cursos", cursos);
        return "/admin/listarCurso";
    }

    @PostMapping("/salvarCurso")
    public String salvarCurso(@Valid Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/cadastroCurso";
        }
        cursoRepository.save(curso);
        model.addAttribute("cursos", cursoRepository.findAll());
        return "redirect:/listarCurso";
    }

    @RequestMapping("/excluirCurso/{id}")
    public String excluirCurso(@PathVariable Integer id, Model model) {
        try {
            cursoRepository.deleteById(id);
            model.addAttribute("cursos", cursoRepository.findAll());
        } catch (ConstraintViolationException constraintViolationException) {
            model.addAttribute("erroAoExcluir", true);
        }
        return "redirect:/listarCurso";
    }

    @RequestMapping("/editarCurso/{id}")
    public String editarCurso(@PathVariable Integer id, Model model) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não foi possível encontrar esse Curso"));
        model.addAttribute("curso", curso);
        return "redirect:/cadastrarCurso";
    }
}
