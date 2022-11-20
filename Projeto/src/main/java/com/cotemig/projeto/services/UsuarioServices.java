package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Chamado;
import com.cotemig.projeto.model.Usuario;
import com.cotemig.projeto.repository.ChamadoRepository;
import com.cotemig.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServices implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
   private ChamadoRepository chamadoRepository;

    //Pega somente um usuario por Id
    public Usuario getUsuario(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isEmpty()){
           return null;
        }
        return  usuario.get();
    }
//Lista de usuarios
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    //Save Usuario
    public  void saveUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    //Remove Usuario
    public void removerUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    //Teste em banco
    public void adicionarUsuarioTeste(){

        if(getAll().isEmpty()){

            Usuario user1Teste = new Usuario();
            user1Teste.setNome("Paula Vieira");
            user1Teste.setCargo("suporte");
            user1Teste.setEmail("paula@gmail.com");
            user1Teste.setRamal(123);
            user1Teste.setSenha("45789");
           user1Teste.setSetor("vendas");
           saveUsuario(user1Teste);

           user1Teste = new Usuario();
           user1Teste.setNome("Ana Bianca");
           user1Teste.setEmail("ana@gmail.com");
            user1Teste.setCargo("Gerente");
            user1Teste.setRamal(800);
            user1Teste.setSenha("85965");
            user1Teste.setSetor("engenharia");
            saveUsuario(user1Teste);

        }

    }


    //Procurar por usuario por Id
    public Optional<Usuario> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }

    //Atualizar
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

    //Atualiza todos
    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    //Metodos para acesar o chamados

    //Salvar um chamado
    public void saveChamado(Chamado chamado){
        chamadoRepository.save(chamado);
    }

    //Apagar um chamado
    public void deleteChamado(Chamado chamado){
        chamadoRepository.delete(chamado);
    }
}
