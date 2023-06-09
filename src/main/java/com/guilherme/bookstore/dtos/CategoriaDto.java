package com.guilherme.bookstore.dtos;

import com.guilherme.bookstore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo Nome é requerido")
    @Length(min = 3, max = 100, message = "O campo Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo Descrição é requerido")
    @Length(min = 3, max = 100, message = "O campo Descrição deve ter entre 3 e 200 caracteres")
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
