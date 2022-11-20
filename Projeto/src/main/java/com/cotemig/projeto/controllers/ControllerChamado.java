package com.cotemig.projeto.controllers;

import com.cotemig.projeto.model.Chamado;
import com.cotemig.projeto.services.ChamadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chamados")
public class ControllerChamado {

    @Autowired
    private ChamadoServices chamadoServices;
    @PostMapping("/novoChamado")
    public ResponseEntity<Chamado> addChamado(@NonNull @Validated @RequestBody Chamado chamado){

        chamadoServices.saveChamado(chamado);
        return new ResponseEntity<>(chamado, HttpStatus.OK);
    }

    @DeleteMapping("/deletechamado/{id}")
    public ResponseEntity<Chamado> deletarChamado (@NonNull @Validated @PathVariable Integer id){

        Chamado chamado = chamadoServices.getChamadoById(id);

        if(chamado == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        chamadoServices.deleteChamadoById(id);;
        return new ResponseEntity<>(chamado, HttpStatus.OK);
    }
}