package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Usuario;


import java.util.List;
import java.util.Optional;


public interface UsuarioService {

    Optional<Usuario> getUsuarioById(Integer id);
    List<Usuario> getAllUsuarios();
    void deleteAllUsuarios();
    void deleteUsuarioById(Integer id);
    void updateUsuarioById(Integer id, Usuario usuario);
    void updateUsuario(Usuario usuario);
    void insertUsuario(Usuario usuario);

    Usuario findUsuarioByEmail(String email);

    boolean findPerfilByUsuario(String cargo, Usuario usuario);

    boolean isAdministrador(Usuario usuario);

    boolean isAtendente(Usuario usuario);


}
