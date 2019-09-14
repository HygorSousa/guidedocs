package com.unitins.guideDocs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"datacadastro", "dataalteracao"},
        allowGetters = true
)
public abstract class AuditoriaModel implements Serializable {
    @Column(name = "datacadastro", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate datacadastro;

    @Column(name = "dataalteracao", nullable = false)
    @LastModifiedDate
    private LocalDate dataalteracao;


    public LocalDate getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(LocalDate datacadastro) {
        this.datacadastro = datacadastro;
    }

    public LocalDate getDataalteracao() {
        return dataalteracao;
    }

    public void setDataalteracao(LocalDate dataalteracao) {
        this.dataalteracao = dataalteracao;
    }
}
