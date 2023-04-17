package com.guilherme.bookstore.dtos;

import com.guilherme.bookstore.domain.Livro;

import java.io.Serializable;

public class LivroDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public LivroDto() {
        super();
    }

    public LivroDto(Integer id, String titulo) {
        super();
        this.id = id;
        this.titulo = titulo;
    }

    public LivroDto(Livro obj) {
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
