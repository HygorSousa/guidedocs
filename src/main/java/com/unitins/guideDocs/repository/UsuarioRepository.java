package com.unitins.guideDocs.repository;

import com.unitins.guideDocs.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByLogin(String login);
}
