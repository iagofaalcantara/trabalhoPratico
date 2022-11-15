package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Usuario;
import com.cotemig.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuario(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isEmpty()){
           return null;
        }
        return  usuario.get();
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }
    public  void saveUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void removerUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    public void adicionarUsuarioTeste(){

        if(getAll().isEmpty()){

            Usuario user1Teste = new Usuario();
            user1Teste.setNome("Paula Vieira");
            user1Teste.setCargo("suporte");
            user1Teste.setEmail("paula@gmail.com");
            user1Teste.setRamal(123);
            user1Teste.setSenha("45789");
           user1Teste.setSetor("vendas");

           user1Teste = new Usuario();
           user1Teste.setNome("Ana Bianca");
           user1Teste.setEmail("ana@gmail.com");
            user1Teste.setCargo("Gerente");
            user1Teste.setRamal(800);
            user1Teste.setSenha("85965");
            user1Teste.setSetor("engenharia");

        }

    }
}
