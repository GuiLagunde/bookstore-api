package com.guilherme.bookstore.service;

import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.repositories.CategoriaRepository;
import com.guilherme.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){
        Categoria cat2 = new Categoria(null,"ficição","livros de ficiçao");
        Categoria cat3 = new Categoria(null,"biografias","livros de ficiçao");
        Categoria cat1 = new Categoria(null,"Informática","Livros de ti");
        Livro l1 = new Livro(null,"Clean Code", "Robert Martin", "Loren ipsum", cat1);
        Livro l2 = new Livro(null,"engenharia de software", "louis", "Loren ipsum", cat2);
        Livro l3 = new Livro(null,"i roobot", "isac", "Loren ipsum", cat2);
        cat1.getLivros().addAll(Arrays.asList(l1));
        cat2.getLivros().addAll(Arrays.asList(l2));
        this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        this.livroRepository.saveAll(Arrays.asList(l1,l2,l3));
    }
}
