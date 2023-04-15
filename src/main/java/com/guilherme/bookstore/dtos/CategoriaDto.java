package com.guilherme.bookstore.dtos;

import com.guilherme.bookstore.domain.Categoria;

import java.io.Serializable;

public class CategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private  String nome;
    private String descricao;

    public CategoriaDto() {
        super();
    }

    public CategoriaDto(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
