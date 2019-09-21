package com.unitins.guideDocs.repository;

import com.unitins.guideDocs.models.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UsuarioRepository usuarioRepository;

    public DbInit(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.usuarioRepository.deleteAll();

        // Crete users
        Usuario admin = new Usuario("admin", new BCryptPasswordEncoder().encode("admin"), "ADMIN");
        Usuario professor = new Usuario("professor", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR");
        Usuario aluno = new Usuario("aluno", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");

        List<Usuario> users = Arrays.asList(admin, professor, aluno);

        // Save to db
        this.usuarioRepository.saveAll(users);
    }
}