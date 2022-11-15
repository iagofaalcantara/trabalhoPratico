package com.cotemig.projeto.controllers;


import com.cotemig.projeto.model.Usuario;
import com.cotemig.projeto.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuário {

    @Autowired
    private  UsuarioServices usuarioServices;
    @GetMapping("/{id}")
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

    @PostMapping("/novo")
    public ResponseEntity<Usuario> addUsuario(@NonNull @Validated @RequestBody Usuario usuario){

        usuarioServices.saveUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Usuario> editarUsuario( @NonNull @Validated @RequestBody Usuario usuario, @PathVariable Integer id ){

        Usuario usuarioSearch = usuarioServices.getUsuario(id);

        if(usuarioSearch == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        usuario.setId(usuarioSearch.getId());
        usuarioServices.saveUsuario(usuarioSearch);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> deletarUsuario (@NonNull @Validated @PathVariable Integer id){

        Usuario usuario = usuarioServices.getUsuario(id);

        if(usuario == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        usuarioServices.removerUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> todosUsuarios(){

        usuarioServices.adicionarUsuarioTeste();
        return new ResponseEntity<>(usuarioServices.getAll(), HttpStatus.OK);
    }
}
