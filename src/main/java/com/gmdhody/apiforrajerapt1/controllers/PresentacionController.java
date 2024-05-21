package com.gmdhody.apiforrajerapt1.controllers;

import com.gmdhody.apiforrajerapt1.dto.PresentacionDto;
import com.gmdhody.apiforrajerapt1.entities.Presentacion;
import com.gmdhody.apiforrajerapt1.services.PresentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/presentacion")
public class PresentacionController {
    @Autowired
    private PresentacionService service;
    @GetMapping
    public ResponseEntity<List<Presentacion>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Presentacion> create(@RequestBody PresentacionDto presentacionDto){
        return new ResponseEntity<>(service.create(presentacionDto),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Presentacion> update(@PathVariable("id")Integer id,@RequestBody PresentacionDto presentacionDto){
        return new ResponseEntity<>(service.update(id,presentacionDto),HttpStatus.OK);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Presentacion> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
