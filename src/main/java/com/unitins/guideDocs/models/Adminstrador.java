package com.unitins.guideDocs.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Adminstrador extends Pessoa {

    public Adminstrador() {
    }

    public Adminstrador(String nome, String matricula, String cpf, String senha, String roles) {
        setNome(nome);
        setMatricula(matricula);
        setCpf(cpf);
        setSenha(senha);
        setRoles(roles);
    }
}
