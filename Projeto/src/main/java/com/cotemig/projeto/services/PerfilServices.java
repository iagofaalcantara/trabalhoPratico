package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Perfil;
import com.cotemig.projeto.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PerfilServices {
    @Autowired
    private PerfilRepository perfilRepository;
    public Perfil getPerfil(Integer id){
        Optional<Perfil> perfil = perfilRepository.findById(id);

        if(perfil.isEmpty()){
            return null;
        }
        return  perfil.get();
    }

    public List<Perfil> getAll(){
        return perfilRepository.findAll();
    }
    public  void savePerfil(Perfil perfil){
        perfilRepository.save(perfil);
    }

    public void removerPerfil(Perfil perfil){
        perfilRepository.delete(perfil);
    }

    public void adicionarPerfil(){

            Perfil perfil = new Perfil();
            perfil.setTipo("Administrador");
            savePerfil(perfil);

            perfil = new Perfil();
            perfil.setTipo("Atendente");
            savePerfil(perfil);

    }
}
