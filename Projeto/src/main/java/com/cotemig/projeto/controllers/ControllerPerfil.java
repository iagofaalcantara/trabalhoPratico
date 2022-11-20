package com.cotemig.projeto.controllers;

import com.cotemig.projeto.model.Perfil;
import com.cotemig.projeto.services.PerfilServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("perfil")
public class ControllerPerfil{
    @Autowired
    private PerfilServices perfilServices;
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfil(@PathVariable("id") Integer id){

        if(id < 0){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Perfil perfil = perfilServices.getPerfil(id);

        if(perfil == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(perfil, HttpStatus.OK);
    }

    @PostMapping("/novoPerfil")
    public ResponseEntity<Perfil> addPerfil(@NonNull @Validated @RequestBody Perfil perfil){
        perfilServices.savePerfil(perfil);
        return new ResponseEntity<>(perfil, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Perfil> updatePerfil( @NonNull @Validated @RequestBody Perfil perfil, @PathVariable Integer id ){

        Perfil perfilSearch = perfilServices.getPerfil(id);

        if(perfilSearch == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        perfil.setId(perfilSearch.getId());
        perfilServices.savePerfil(perfilSearch);

        return new ResponseEntity<>(perfil, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Perfil> deletePerfil (@NonNull @Validated @PathVariable Integer id){

        Perfil perfil = perfilServices.getPerfil(id);

        if(perfil == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        perfilServices.deletePerfil(perfil);
        return new ResponseEntity<>(perfil, HttpStatus.OK);
    }

    @GetMapping("/listaPerfis")
    public ResponseEntity<List<Perfil>> todosPerfis(){

        perfilServices.adicionarPerfil();
        return new ResponseEntity<>(perfilServices.getAllPerfis(), HttpStatus.OK);
    }


}
