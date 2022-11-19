package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Perfil;
import com.cotemig.projeto.model.Usuario;
import com.cotemig.projeto.repository.PerfilRepository;
import com.cotemig.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;


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
    public void updateUsuarioById(Integer id, Usuario usuario) {
        Optional<Usuario> getUsuario = getUsuarioById(id);

       getUsuario.get().setNome(usuario.getNome());
       getUsuario.get().setSetor(usuario.getSetor());
       getUsuario.get().setCargo(usuario.getCargo());
       getUsuario.get().setEmail(usuario.getEmail());
       getUsuario.get().setSenha(usuario.getSenha());
       getUsuario.get().setRamal(usuario.getRamal());



       usuarioRepository.save(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
     usuarioRepository.save(usuario);
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public boolean findPerfilByUsuario(String perfil, Usuario usuario) {
        return usuario.getPerfil().equals(perfilRepository.findByPerfil(perfil));
    }

    @Override
    public boolean isAdministrador(Usuario usuario) {
        return usuario.getPerfil().equals("Administrador");
    }

    @Override
    public boolean isAtendente(Usuario usuario) {
        return usuario.getPerfil().equals("Atendente");
    }




    public void insertUsuario(Usuario usuario, Perfil perfil) {

        if(perfil.getTipo() == "administrador"){
             usuarioRepository.save(usuario);
        }
    }
}
