package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Solicitante;
import com.cotemig.projeto.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitanteServices implements SolicitanteService{

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    public Solicitante getSolicitante(Integer id){
        Optional<Solicitante> solicitante = solicitanteRepository.findById(id);

        if(solicitante.isEmpty()){
           return null;
        }
        return  solicitante.get();
    }

    public List<Solicitante> getAllSolicitantes(){
        return solicitanteRepository.findAll();
    }
    public  void saveSolicitante(Solicitante solicitante){
        solicitanteRepository.save(solicitante);
    }

    public void deleteSolicitante(Solicitante solicitante){
        solicitanteRepository.delete(solicitante);
    }

    public void adicionarSolicitante(){

        if(getAllSolicitantes().isEmpty()){

            Solicitante solicitante = new Solicitante();
            solicitante.setNome("Lívia Bragança");
            solicitante.setCargo("Desenvolvedora");
            solicitante.setEmail("livia.fsb@gmail.com");
            solicitante.setRamal(555);
            solicitante.setSenha("2020");
            solicitante.setSetor("TI");
            saveSolicitante(solicitante);

            solicitante = new Solicitante();
            solicitante.setNome("Iago Alcantara");
            solicitante.setCargo("Diretor Presidente");
            solicitante.setEmail("iago@cotemig.com");
            solicitante.setRamal(818);
            solicitante.setSenha("bh2022");
            solicitante.setSetor("Presidência");
            saveSolicitante(solicitante);

            solicitante = new Solicitante();
            solicitante.setNome("Paula Beatriz");
            solicitante.setCargo("Diretora de Desenvolvimento");
            solicitante.setEmail("paula@cotemig.com");
            solicitante.setRamal(755);
            solicitante.setSenha("bia2022");
            solicitante.setSetor("Diretoria de Desenvolvimento");
            saveSolicitante(solicitante);

            solicitante = new Solicitante();
            solicitante.setNome("Eliana Carsoso");
            solicitante.setCargo("Diretora de Recursos Humanos");
            solicitante.setEmail("eliana@cotemig.com");
            solicitante.setRamal(895);
            solicitante.setSenha("eliana2022");
            solicitante.setSetor("Diretoria de Recursos Humanos");
            saveSolicitante(solicitante);
        }
    }
}
