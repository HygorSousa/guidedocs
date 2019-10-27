package com.unitins.guideDocs.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Aluno extends Pessoa {

    @ManyToOne
    private Turma turma;

    public Aluno() {
    }

    public Aluno(String nome, String matricula, String cpf, String senha, String roles) {
        setNome(nome);
        setMatricula(matricula);
        setCpf(cpf);
        setSenha(senha);
        setRoles(roles);
    }

}
