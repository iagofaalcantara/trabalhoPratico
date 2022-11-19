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


}
