package com.guilherme.bookstore.resources;

import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.dtos.CategoriaDto;
import com.guilherme.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categoria> list = categoriaService.findAll();
        List<CategoriaDto> listDto = list.stream().map(categoria -> new CategoriaDto(categoria)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria obj){
        obj = categoriaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Integer id, @RequestBody CategoriaDto categoriaDto){
        Categoria categoria = categoriaService.create(id,categoriaDto);
        return ResponseEntity.ok().body(new CategoriaDto(categoria));
    }
}
