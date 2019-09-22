package com.unitins.guideDocs.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Aluno extends Pessoa {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ProcessoOrientacao processoOrientacao;

    public ProcessoOrientacao getProcessoOrientacao() {
        return processoOrientacao;
    }

    public void setProcessoOrientacao(ProcessoOrientacao processoOrientacao) {
        this.processoOrientacao = processoOrientacao;
    }
}
