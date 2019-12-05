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
	@JoinTable(name = "AreaConhecimentoProfessor", joinColumns = @JoinColumn(name = "idProfessor"), inverseJoinColumns = @JoinColumn(name = "idAreaConhecimento"))
	private List<AreaConhecimento> areasConhecimento;

	@OneToMany
	@JoinTable(name = "DisponibilidadeProfessor", joinColumns = @JoinColumn(name = "idProfessor"), inverseJoinColumns = @JoinColumn(name = "idDisponibilidade"))
	private List<Disponibilidade> disponibilidades;

	public Professor() {
	}

	private String nome;
	private String matricula;
	private String cpf;
	private String senha;
	private String roles;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Professor(String nome, String matricula, String cpf, String senha, String roles) {
		setNome(nome);
		setMatricula(matricula);
		setCpf(cpf);
		setSenha(senha);
		setRoles(roles);
	}
}
