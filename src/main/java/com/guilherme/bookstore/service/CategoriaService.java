package com.guilherme.bookstore.service;

import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.dtos.CategoriaDto;
import com.guilherme.bookstore.service.exceptions.DataIntegrityViolationException;
import com.guilherme.bookstore.service.exceptions.ObjectNotFoundException;
import com.guilherme.bookstore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria findById(Integer id){

        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(" Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria create(Integer id, CategoriaDto categoriaDto) {
        Categoria categoria = findById(id);
        categoria.setNome(categoriaDto.getNome());
        categoria.setNome(categoriaDto.getNome());
        categoria.setDescricao(categoriaDto.getDescricao());
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        }catch (org.springframework.dao.DataIntegrityViolationException e){
            throw  new DataIntegrityViolationException("Objeto não pode ser deletada! Possui livros associados");
        }


    }
}
