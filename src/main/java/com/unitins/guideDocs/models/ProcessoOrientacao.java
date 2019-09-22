package com.unitins.guideDocs.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProcessoOrientacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Status status;

    private String titulo;

    private String descricao;

    private TipoProcessoOrientacao tipoProcessoOrietacao;

    @OneToOne(fetch = FetchType.LAZY)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprofessororietador")
    private Professor professorOrientador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idintencaoorientador")
    private Professor intencaoOrientador;

    @OneToMany
    @JoinTable(name = "DocumentosProcessoOrientacao",
            joinColumns = @JoinColumn(name = "idProcessoOrientacao"),
            inverseJoinColumns = @JoinColumn(name = "idDocumento"))
    private List<Documento> documentos;

    @OneToMany
    @JoinTable(name = "AreaConhecimentoProcessoOrientacao",
            joinColumns = @JoinColumn(name = "idProcessoOrientacao"),
            inverseJoinColumns = @JoinColumn(name = "idAreaConhecimento"))
    private List<AreaConhecimento> areasConhecimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProcessoOrientacao getTipoProcessoOrietacao() {
        return tipoProcessoOrietacao;
    }

    public void setTipoProcessoOrietacao(TipoProcessoOrientacao tipoProcessoOrietacao) {
        this.tipoProcessoOrietacao = tipoProcessoOrietacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessorOrientador() {
        return professorOrientador;
    }

    public void setProfessorOrientador(Professor professorOrientador) {
        this.professorOrientador = professorOrientador;
    }

    public Professor getIntencaoOrientador() {
        return intencaoOrientador;
    }

    public void setIntencaoOrientador(Professor intencaoOrientador) {
        this.intencaoOrientador = intencaoOrientador;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<AreaConhecimento> getAreasConhecimento() {
        return areasConhecimento;
    }

    public void setAreasConhecimento(List<AreaConhecimento> areasConhecimento) {
        this.areasConhecimento = areasConhecimento;
    }
}
