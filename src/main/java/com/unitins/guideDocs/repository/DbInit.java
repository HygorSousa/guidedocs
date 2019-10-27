package com.unitins.guideDocs.repository;

import com.unitins.guideDocs.models.Adminstrador;
import com.unitins.guideDocs.models.Aluno;
import com.unitins.guideDocs.models.Pessoa;
import com.unitins.guideDocs.models.Professor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private PessoaRepository pessoaRepository;

    public DbInit(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.pessoaRepository.deleteAll();

        // Crete users
        Pessoa admin = new Adminstrador("Administrador", "111111", "admin", new BCryptPasswordEncoder().encode("admin"), "ADMIN");
        Pessoa professor = new Professor("Professor", "2222222", "professor", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR");
        Pessoa aluno = new Aluno("Aluno", "33333333", "aluno", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");

        List<Pessoa> users = Arrays.asList(admin, professor, aluno);

        // Save to db
        this.pessoaRepository.saveAll(users);
    }
}