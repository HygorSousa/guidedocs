package com.unitins.guideDocs.repository;

import com.unitins.guideDocs.models.ProcessoOrientacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcessoOrientacaoRepository extends JpaRepository<ProcessoOrientacao, String> {

    Optional<ProcessoOrientacao> findByAlunoCpf(String cpf);

    Optional<ProcessoOrientacao> findById(Integer idprocesso);
}
