package com.guilherme.bookstore.resources;

import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.dtos.LivroDto;
import com.guilherme.bookstore.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value="categoria", defaultValue = "0")Integer id_cat){
        List<Livro> list = livrosService.findAll(id_cat);
        List<LivroDto> listDto = list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id,@RequestBody Livro obj){
        Livro newObj = livrosService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id,@RequestBody Livro obj){
        Livro newObj = livrosService.update(id,obj);
        return ResponseEntity.ok().body(newObj);
    }

}
