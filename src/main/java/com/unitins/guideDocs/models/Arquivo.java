package com.unitins.guideDocs.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Arquivo extends AuditoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caminho;

    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ArquivoPessoa",
            joinColumns = @JoinColumn(name = "idArquivo"),
            inverseJoinColumns = @JoinColumn(name = "idPessoa"))
    private List<Pessoa> pessoas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
