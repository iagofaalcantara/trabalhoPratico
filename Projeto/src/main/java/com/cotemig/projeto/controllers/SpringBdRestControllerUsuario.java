package com.cotemig.projeto.controllers;

import com.cotemig.projeto.model.Usuario;
import com.cotemig.projeto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SpringBdRestControllerUsuario {

    @Autowired
    private UsuarioService usuarioService;



    @RequestMapping(value = "/rest/getAll", method = RequestMethod.GET)
    public List<Usuario> getUsuario() {

        return usuarioService.getAllUsuarios();

    }
    @RequestMapping(value = "/rest/get/{id}", method = RequestMethod.GET)
    public Optional<Usuario> getUsuario(@PathVariable("id") Integer id) {

        return usuarioService.getUsuarioById(id);

    }

    @RequestMapping(value = "/rest/deleteAll", method = RequestMethod.DELETE)
    public void deleteUsuario() {
       usuarioService.deleteAllUsuarios();
    }

    @RequestMapping(value = "/rest/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable("id") Integer id) {

       usuarioService.deleteUsuarioById(id);

    }

    @RequestMapping(value = "/rest/update/{id}", method = RequestMethod.POST)
    public void updateUsuario(@RequestBody Usuario usuario, @PathVariable("id") Integer id) {

       usuarioService.updateUsuarioById(id, usuario);

    }

    @RequestMapping(value = "/rest/insert", method = RequestMethod.POST)
    public void updateUsuario(@RequestBody Usuario usuario) {

        usuarioService.insertUsuario(usuario);

    }
}
