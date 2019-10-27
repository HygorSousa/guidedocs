package com.unitins.guideDocs.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Professor extends Pessoa {

    private boolean professorDisciplina;

    private TipoProcessoOrientacao disciplina;

    @OneToMany(mappedBy = "professorOrientador")
    private List<ProcessoOrientacao> orientacoes;

    @OneToMany
    @JoinTable(name = "AreaConhecimentoProfessor",
            joinColumns = @JoinColumn(name = "idProfessor"),
            inverseJoinColumns = @JoinColumn(name = "idAreaConhecimento"))
    private List<AreaConhecimento> areasConhecimento;

    @OneToMany
    @JoinTable(name = "DisponibilidadeProfessor",
            joinColumns = @JoinColumn(name = "idProfessor"),
            inverseJoinColumns = @JoinColumn(name = "idDisponibilidade"))
    private List<Disponibilidade> disponibilidades;

    public Professor() {
    }

    public Professor(String nome, String matricula, String cpf, String senha, String roles) {
        setNome(nome);
        setMatricula(matricula);
        setCpf(cpf);
        setSenha(senha);
        setRoles(roles);
    }
}
