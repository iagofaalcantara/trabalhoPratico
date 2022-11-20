package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Chamado;

import com.cotemig.projeto.repository.AtendenteRepository;
import com.cotemig.projeto.repository.ChamadoRepository;
import com.cotemig.projeto.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ChamadoServices implements ChamadoService{

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    SolicitanteRepository solicitanteRepository;

    @Autowired
    AtendenteRepository atendenteRepository;

    @Override
    public Chamado getChamadoById(Integer id) {
        return null;
    }

    @Override
    public List<Chamado> getAllChamados() {
        return chamadoRepository.findAll();
    }

    @Override
    public void deleteAllChamados() {
        chamadoRepository.deleteAll();
    }

    @Override
    public void deleteChamadoById(Integer id) {
        chamadoRepository.deleteById(id);
    }

    public void adicionarChamados(){
        Chamado chamado = new Chamado();
        chamado.setData("20/11/2022");
        chamado.setDescricao("Erro de conexão");
        chamado.setNivelPrioridade(4);
        chamado.setStatus("Aberto");
        chamado.setTipo("Suporte");
        saveChamado(chamado);

        chamado = new Chamado();
        chamado.setData("17/11/2022");
        chamado.setDescricao("Troca de monitor");
        chamado.setNivelPrioridade(1);
        chamado.setStatus("Fechado");
        chamado.setTipo("Alteração de hardware");
        saveChamado(chamado);

        chamado = new Chamado();
        chamado.setData("15/11/2022");
        chamado.setDescricao("Atualização de programa");
        chamado.setNivelPrioridade(5);
        chamado.setStatus("Aberto");
        chamado.setTipo("Suporte");
        saveChamado(chamado);
    }
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
        chamado1.setStatus("Pendente");
        chamado1.setNivelPrioridade(3);


    }
}
