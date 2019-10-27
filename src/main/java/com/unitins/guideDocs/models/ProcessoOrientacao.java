package com.unitins.guideDocs.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ProcessoOrientacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Status status;

    private String titulo;

    private String descricao;

    private TipoProcessoOrientacao tipoProcessoOrietacao;

    @ManyToOne(fetch = FetchType.LAZY)
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
}
