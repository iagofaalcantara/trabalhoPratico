package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Atendente;
import com.cotemig.projeto.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendenteServices {

    @Autowired
    AtendenteRepository atendenteRepository;

    public Atendente getAtendente(Integer id){

        Optional<Atendente> atendente = atendenteRepository.findById(id);
        if (atendente.isEmpty()){

            return null;
        }
        return atendente.get();
    }

    public List<Atendente>  getlAll(){

        return atendenteRepository.findAll();

    }
    public void saveAtendente(Atendente atendente){

        atendenteRepository.save(atendente);
    }
    public void deleteAtendente(Atendente atendente){

        atendenteRepository.delete(atendente);

    }

    public void adicionarAtendenteTest(){

        Atendente atendente1 = new Atendente();

        atendente1.setNome("Bia");
        atendente1.setCargo("atendente");
        atendente1.setEmail("bia.cotemig@gmail.com");
        atendente1.setRamal(4669);
        atendente1.setSetor("ICT");

    }


}
