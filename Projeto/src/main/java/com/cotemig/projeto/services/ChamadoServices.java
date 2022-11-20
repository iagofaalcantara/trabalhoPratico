package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Chamado;
import com.cotemig.projeto.repository.ChamadoRepository;
import com.cotemig.projeto.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ChamadoServices {

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    SolicitanteRepository solicitanteRepository;

    public Chamado getAtendente(Integer id){
        Optional<Chamado> chamados = chamadoRepository.findById(id);
        if(chamados.isEmpty()){
            return null;
        }
        return chamados.get();
    }

    public List<Chamado> getAll (){
        return chamadoRepository.findAll();
    }

    public void saveChamado(Chamado chamado){
        chamadoRepository.save(chamado);
    }

    public void deleteChamado(Chamado chamado){
        chamadoRepository.delete(chamado);
    }

    public void adicionarChamadoTeste(){
        Chamado chamado1 = new Chamado();
        chamado1.setTipo("A");
        chamado1.setDescricao("Teste");
        chamado1.setData("24/05/2022");
        chamado1.setAnexo(null);
        chamado1.setStatus("Pendente");
        chamado1.setNivelPrioridade(3);


    }


}
