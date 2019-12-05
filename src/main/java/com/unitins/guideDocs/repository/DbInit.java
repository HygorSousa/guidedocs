package com.unitins.guideDocs.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
    private PessoaRepository pessoaRepository;
    private final ProcessoOrientacaoRepository processoOrientacaoRepository;

    public DbInit(PessoaRepository pessoaRepository, ProcessoOrientacaoRepository processoOrientacaoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.processoOrientacaoRepository = processoOrientacaoRepository;
    }

    @Override
    public void run(String... args) {
//        // Delete all
//        this.pessoaRepository.deleteAll();
//
//        // Crete users
//        Pessoa admin = new Adminstrador("Administrador", "111111", "admin", new BCryptPasswordEncoder().encode("admin"), "ADMIN");
//        Pessoa professor = new Professor("Professor", "2222222", "professor", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR");
//        Pessoa aluno = new Aluno("Aluno", "33333333", "aluno", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
//
//        ProcessoOrientacao processoOrientacao = new ProcessoOrientacao(Status.ANALISE, "Testando", "Processo Teste", TipoProcessoOrientacao.PCC, (Aluno) aluno, (Professor) professor);
//
//        List<Pessoa> users = Arrays.asList(admin, professor, aluno);
//
//        // Save to db
//        this.pessoaRepository.saveAll(users);
//        this.processoOrientacaoRepository.save(processoOrientacao);
    }
}