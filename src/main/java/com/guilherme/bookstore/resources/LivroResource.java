package com.guilherme.bookstore.resources;

import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivrosService livrosService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro livro = livrosService.findById(id);
        return ResponseEntity.ok().body(livro);
    }
}
