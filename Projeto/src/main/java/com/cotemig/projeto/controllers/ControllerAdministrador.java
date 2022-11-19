package com.cotemig.projeto.controllers;


import com.cotemig.projeto.model.Atendente;
import com.cotemig.projeto.model.Usuario;
import com.cotemig.projeto.services.AdministradorService;
import com.cotemig.projeto.services.AtendenteServices;
import com.cotemig.projeto.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("administrador")
public class ControllerAdministrador {


    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private AtendenteServices atendenteServices;

    @Autowired
    private UsuarioServices usuarioServices;


    @PostMapping("/novoAtendente")
    public ResponseEntity<Atendente> addAtendente(@NonNull @Validated @RequestBody Atendente atendente){

        atendenteServices.saveAtendente(atendente);
        return new ResponseEntity<>(atendente, HttpStatus.OK);
    }
    @PostMapping("/novoUsuario")
    public ResponseEntity<Usuario> addUsuario(@NonNull @Validated @RequestBody Usuario usuario){

        usuarioServices.saveUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/deleteusuario/{id}")
    public ResponseEntity<Usuario> deletarUsuario (@NonNull @Validated @PathVariable Integer id){

        Usuario usuario = usuarioServices.getUsuario(id);

        if(usuario == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        usuarioServices.removerUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/listaUsuarios")
    public ResponseEntity<List<Usuario>>  getAllUsuarios(){
        usuarioServices.adicionarUsuarioTeste();
        return new ResponseEntity<>(usuarioServices.getAllUsuarios(), HttpStatus.OK);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Integer id){

        if(id < 0){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = usuarioServices.getUsuario(id);

        if(usuario == null){

            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    @GetMapping("/listaAtendentes")
    public ResponseEntity<List<Atendente>> todosAtendentes(){

        atendenteServices.adicionarAtendenteTest();
       return new ResponseEntity<>(atendenteServices.getAllAtendentes(), HttpStatus.OK);
    }

    @GetMapping("/atendente/{id}")

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
    @DeleteMapping("/deleteAtendente/{id}")
    public ResponseEntity<Atendente> deleteAtendente (@NonNull @Validated @PathVariable Integer id){

        Atendente atendente = atendenteServices.getAtendente(id);

        if(atendente == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        atendenteServices.deleteAtendente(atendente);
        return new ResponseEntity<>(atendente, HttpStatus.OK);
    }
}
