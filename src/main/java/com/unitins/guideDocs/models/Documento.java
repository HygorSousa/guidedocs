package com.unitins.guideDocs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean assinadoAluno;

    private boolean assinadoProfessor;

    private TipoDocumento tipoDocumento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssinadoAluno() {
        return assinadoAluno;
    }

    public void setAssinadoAluno(boolean assinadoAluno) {
        this.assinadoAluno = assinadoAluno;
    }

    public boolean isAssinadoProfessor() {
        return assinadoProfessor;
    }

    public void setAssinadoProfessor(boolean assinadoProfessor) {
        this.assinadoProfessor = assinadoProfessor;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
