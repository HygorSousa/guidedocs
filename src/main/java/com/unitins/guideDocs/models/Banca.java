package com.unitins.guideDocs.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Banca extends AuditoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Temporal(TemporalType.TIME)
    private Date hora;

    @OneToMany
    @JoinTable(name = "ProfessorBanca",
            joinColumns = @JoinColumn(name = "idBanca"),
            inverseJoinColumns = @JoinColumn(name = "idProfessor"))
    private List<Professor> professores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
}
