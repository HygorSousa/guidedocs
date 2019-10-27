package com.unitins.guideDocs.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Temporal(TemporalType.TIME)
    private Date horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idprofessor")
    private Professor professor;
}
