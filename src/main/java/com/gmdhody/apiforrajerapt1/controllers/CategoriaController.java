package com.gmdhody.apiforrajerapt1.controllers;

import com.gmdhody.apiforrajerapt1.dto.CategoriaDto;
import com.gmdhody.apiforrajerapt1.entities.Categoria;
import com.gmdhody.apiforrajerapt1.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;
    @GetMapping
    public ResponseEntity<List<Categoria>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Categoria> create(@RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(service.create(categoriaDto),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> update(@PathVariable("id")Integer id,@RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(service.update(id,categoriaDto),HttpStatus.OK);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
