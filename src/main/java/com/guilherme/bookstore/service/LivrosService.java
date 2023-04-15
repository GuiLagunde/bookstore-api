package com.guilherme.bookstore.service;

import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.repositories.LivroRepository;
import com.guilherme.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
   private LivroRepository livroRepository;

    public Livro findById(Integer id){

        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(" Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }
}
