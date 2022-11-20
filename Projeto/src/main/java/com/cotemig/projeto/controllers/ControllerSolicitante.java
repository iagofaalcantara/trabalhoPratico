package com.cotemig.projeto.controllers;

import com.cotemig.projeto.model.Chamado;
import com.cotemig.projeto.model.Solicitante;
import com.cotemig.projeto.services.ChamadoServices;
import com.cotemig.projeto.services.SolicitanteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("solicitante")
public class ControllerSolicitante{
    @Autowired
    private SolicitanteServices solicitanteServices;

    @Autowired
    private ChamadoServices chamadoServices;

    @GetMapping("/{id}")
    public ResponseEntity<Solicitante> getSolicitante(@PathVariable("id") Integer id){

        if(id < 0){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Solicitante solicitante = solicitanteServices.getSolicitante(id);

        if(solicitante == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(solicitante, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Solicitante> updateSolicitante( @NonNull @Validated @RequestBody Solicitante solicitante, @PathVariable Integer id ){

        Solicitante solicitanteSearch = solicitanteServices.getSolicitante(id);

        if(solicitanteSearch == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        solicitante.setId(solicitanteSearch.getId());
        solicitanteServices.saveSolicitante(solicitanteSearch);

        return new ResponseEntity<>(solicitante, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Solicitante> deleteSolicitante(@NonNull @Validated @PathVariable Integer id){

        Solicitante solicitante = solicitanteServices.getSolicitante(id);

        if(solicitante == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        solicitanteServices.deleteSolicitante(solicitante);
        return new ResponseEntity<>(solicitante, HttpStatus.OK);
    }

    @PostMapping("/novoChamado")
    public ResponseEntity<Chamado> addChamado(@NonNull @Validated @RequestBody Chamado chamado){

        chamadoServices.saveChamado(chamado);
        return new ResponseEntity<>(chamado, HttpStatus.OK);
    }
}
