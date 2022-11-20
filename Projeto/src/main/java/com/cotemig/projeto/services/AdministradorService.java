package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Atendente;
import com.cotemig.projeto.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface AdministradorService {
    Optional<Usuario> getUsuarioById(Integer id);
    List<Usuario> getAllUsuarios();
    void deleteAllUsuarios();
    void deleteUsuarioById(Integer id);
    void insertUsuario(Usuario usuario);
    void deleteAtendente(Atendente atendente);
    void saveAtendente(Atendente atendente);

}
