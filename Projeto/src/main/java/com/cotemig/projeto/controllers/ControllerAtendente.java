package com.cotemig.projeto.controllers;

import com.cotemig.projeto.model.Atendente;
import com.cotemig.projeto.services.AtendenteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendente")
public class ControllerAtendente {

    @Autowired
    private AtendenteServices atendenteServices;
    @GetMapping("/{id}")

    public ResponseEntity<Atendente> getAtendente(@PathVariable("id") Integer id){

        if(id < 0){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Atendente atendente = atendenteServices.getAtendente(id);

        if(atendente == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(atendente, HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<Atendente> addAtendente(@NonNull @Validated @RequestBody Atendente atendente){

        atendenteServices.saveAtendente(atendente);
        return new ResponseEntity<>(atendente, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Atendente> updateAtendente( @NonNull @Validated @RequestBody Atendente atendente, @PathVariable Integer id ){

        Atendente atendenteSearch = atendenteServices.getAtendente(id);

        if(atendenteSearch == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        atendente.setId(atendenteSearch.getId());
       atendenteServices.saveAtendente(atendenteSearch);

        return new ResponseEntity<>(atendente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Atendente> deleteAtendente (@NonNull @Validated @PathVariable Integer id){

        Atendente atendente = atendenteServices.getAtendente(id);

        if(atendente == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        atendenteServices.deleteAtendente(atendente);
        return new ResponseEntity<>(atendente, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Atendente>> todosAtendentes(){

        atendenteServices.adicionarAtendenteTest();
       return new ResponseEntity<>(atendenteServices.getAll(), HttpStatus.OK);
    }
}
