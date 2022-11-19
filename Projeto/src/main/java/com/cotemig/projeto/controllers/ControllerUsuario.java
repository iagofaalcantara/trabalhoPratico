package com.cotemig.projeto.controllers;


import com.cotemig.projeto.model.Usuario;
import com.cotemig.projeto.services.ChamadoServices;
import com.cotemig.projeto.services.PerfilServices;
import com.cotemig.projeto.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private ChamadoServices chamadoServices;

    @Autowired
    private PerfilServices perfilServices;


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




}
