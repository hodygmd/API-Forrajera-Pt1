package com.gmdhody.apiforrajerapt1.controllers;

import com.gmdhody.apiforrajerapt1.dto.MrcFncnDto;
import com.gmdhody.apiforrajerapt1.entities.Funcion;
import com.gmdhody.apiforrajerapt1.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/funcion")
public class FuncionController {
    @Autowired
    private FuncionService service;
    @GetMapping
    public ResponseEntity<List<Funcion>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Funcion> create(@RequestBody MrcFncnDto mrcFncnDto){
        return new ResponseEntity<>(service.create(mrcFncnDto),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Funcion> update(@PathVariable("id")Integer id,@RequestBody MrcFncnDto mrcFncnDto){
        return new ResponseEntity<>(service.update(id,mrcFncnDto),HttpStatus.OK);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Funcion> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}