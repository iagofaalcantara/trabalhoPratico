package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Chamado;
import com.cotemig.projeto.model.Usuario;

import java.util.List;


public interface UsuarioService {

    void updateUsuarioById(Integer id, Usuario usuario);
    void updateUsuario(Usuario usuario);
    void saveChamado(Chamado chamado);

    void deleteChamado(Chamado chamado);

    public List<Usuario> getAllUsuarios();

}
