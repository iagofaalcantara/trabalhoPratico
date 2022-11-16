package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Solicitante;
import com.cotemig.projeto.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SolicitanteServices {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    public Solicitante getSolicitante(Integer id){
        Optional<Solicitante> solicitante = solicitanteRepository.findById(id);

        if(solicitante.isEmpty()){
           return null;
        }
        return  solicitante.get();
    }

    public List<Solicitante> getAll(){
        return solicitanteRepository.findAll();
    }
    public  void saveSolicitante(Solicitante solicitante){
        solicitanteRepository.save(solicitante);
    }

    public void removerSolicitante(Solicitante solicitante){
        solicitanteRepository.delete(solicitante);
    }

    public void adicionarSolicitanteTeste(){

        if(getAll().isEmpty()){

            Solicitante user1Teste = new Solicitante();
            user1Teste.setNome("Lívia Bragança");
            user1Teste.setCargo("desenvolvedora");
            user1Teste.setEmail("livia.fsb@gmail.com");
            user1Teste.setRamal(555);
            user1Teste.setSenha("2020");
           user1Teste.setSetor("TI");

        }

    }
}
