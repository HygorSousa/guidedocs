package com.unitins.projetointegrador2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unitins.projetointegrador2.model.Proposta;

@Repository
public class PropostaDaoImpl extends AbstractDao<Proposta, Integer> implements PropostaDao {


    public List<Proposta> finByNome(String nome) {
        return createQuery("select p from Proposta p where upper(p.descricao) like concat('%',upper(?1), '%') ", nome);
    }
    
    @Override
	public List<Proposta> findByTeacher(String nome) {
		return createQuery("select p from Proposta p where upper(p.professor.nome) like concat('%',upper(?1), '%') ", nome);
	}

	@Override
	public List<Proposta> finByStudent(String nome) {
		return createQuery("select p from Proposta p where upper(p.aluno.nome) like concat('%',upper(?1), '%') ", nome);
	}
}
