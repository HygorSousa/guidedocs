package com.unitins.guideDocs.repository;

import com.unitins.guideDocs.models.AreaConhecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Integer> {

}
