package com.cotemig.projeto.services;


import com.cotemig.projeto.model.Atendente;
import com.cotemig.projeto.model.Usuario;
import com.cotemig.projeto.repository.AdministradorRepository;
import com.cotemig.projeto.repository.AtendenteRepository;
import com.cotemig.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradoServices implements AdministradorService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AdministradorRepository administradorRepository;

    @Autowired
    AtendenteRepository atendenteRepository;

    @Override
    public Optional<Usuario> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void deleteAllUsuarios() {
        usuarioRepository.deleteAll();
    }

    @Override
    public void deleteUsuarioById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void deleteAtendente(Atendente atendente){

        atendenteRepository.delete(atendente);

    }
    public void saveAtendente(Atendente atendente){

        atendenteRepository.save(atendente);
    }


}
