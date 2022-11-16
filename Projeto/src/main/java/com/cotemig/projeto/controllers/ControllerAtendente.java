package com.cotemig.projeto.controllers;

import com.cotemig.projeto.model.Atendente;
import com.cotemig.projeto.model.Chamado;
import com.cotemig.projeto.model.Solicitante;
import com.cotemig.projeto.services.AtendenteServices;
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
@RequestMapping("atendente")
public class ControllerAtendente {

    @Autowired
    private AtendenteServices atendenteServices;

    @Autowired
    private ChamadoServices chamadoServices;

    @Autowired
    private SolicitanteServices solicitanteServices;


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
    @GetMapping("/consultarchamado/{id}")

    public ResponseEntity<Chamado> consultarChamado (@NonNull @Validated @PathVariable Integer id){

        Chamado chamado = chamadoServices.getChamadoById(id);

        if(chamado == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        chamadoServices.getChamadoById(id);;
        return new ResponseEntity<>(chamado, HttpStatus.OK);
    }
    @GetMapping("/listaChamados")
    public ResponseEntity<List<Chamado>> todosChamados(){
        chamadoServices.adicionarChamados();
        return new ResponseEntity<>(chamadoServices.getAllChamados(), HttpStatus.OK);
    }

    @GetMapping("/listaSolicitantes")
    public ResponseEntity<List<Solicitante>> todosSolicitantes(){

        solicitanteServices.adicionarSolicitante();
        return new ResponseEntity<>(solicitanteServices.getAllSolicitantes(), HttpStatus.OK);
    }
}
