package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Chamado;
import com.cotemig.projeto.repository.ChamadoRepository;
import com.cotemig.projeto.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoServices {

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    SolicitanteRepository solicitanteRepository;

    //Teste em banco
    public void adicionarChamadoTeste(){
        Chamado chamado1 = new Chamado();
        chamado1.setTipo("A");
        chamado1.setDescricao("Teste");
        chamado1.setData("20221511");
        chamado1.setAnexo(null);
        chamado1.setStatus("Pendente");
        chamado1.setNivelPrioridade(3);


    }

}
