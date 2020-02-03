package com.unitins.guideDocs.repository;

import com.unitins.guideDocs.models.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Integer> {

}
