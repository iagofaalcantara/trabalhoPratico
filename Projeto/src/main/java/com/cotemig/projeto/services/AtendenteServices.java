package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Atendente;
import com.cotemig.projeto.model.Chamado;
import com.cotemig.projeto.repository.AtendenteRepository;
import com.cotemig.projeto.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendenteServices implements AtendenteService{

    @Autowired
    AtendenteRepository atendenteRepository;

    @Autowired
    ChamadoRepository chamadoRepository;

    public Chamado getChamado(Integer id) {
        Optional<Chamado> chamados = chamadoRepository.findById(id);
        if (chamados.isEmpty()) {
            return null;
        }
        return chamados.get();
    }

    public List<Chamado> getAllChamados() {
        return chamadoRepository.findAll();
    }

    public void deleteChamado(Chamado chamado) {
        chamadoRepository.delete(chamado);
    }

    @Override
    public Optional<Chamado> getChamadoById(Integer id) {
        return chamadoRepository.findById(id);
    }

    @Override
    public void deleteAllChamados() {
        chamadoRepository.deleteAll();
    }

    @Override
    public void deleteChamadoById(Integer id) {
        chamadoRepository.deleteById(id);
    }

    @Override
    public void insertChamado(Chamado chamado) {
        chamadoRepository.save(chamado);
    }

    @Override
    public void saveChamado(Chamado chamado) {
        chamadoRepository.save(chamado);
    }

    public void saveAtendente(Atendente atendente) {
        atendenteRepository.save(atendente);
    }

    public List<Atendente>  getAllAtendentes(){
        return atendenteRepository.findAll();
    }

    public Atendente getAtendente(Integer id){

        Optional<Atendente> atendente = atendenteRepository.findById(id);
        if (atendente.isEmpty()){

            return null;
        }
        return atendente.get();
    }

    public void deleteAtendente(Atendente atendente) {
        atendenteRepository.delete(atendente);
    }

    public void adicionarAtendentes(){
        Atendente atendente = new Atendente();
        atendente.setNome("José Antônio");
        atendente.setCargo("Analista de Suporte");
        atendente.setEmail("joseantonio@cotemig.br");
        atendente.setRamal(800);
        atendente.setSenha("98980");
        atendente.setSetor("TI");

        atendente = new Atendente();
        atendente.setNome("Maria das Graças");
        atendente.setCargo("Desenvolvedora");
        atendente.setEmail("maria@cotemig.br");
        atendente.setRamal(801);
        atendente.setSenha("96652314");
        atendente.setSetor("Diretoria de Deasenvolvimento");

        atendente = new Atendente();
        atendente.setNome("Marcos");
        atendente.setCargo("Supervisor");
        atendente.setEmail("marcosti@cotemig.br");
        atendente.setRamal(805);
        atendente.setSenha("*892226s");
        atendente.setSetor("TI");
    }
}
