package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Chamado;

import java.util.List;
import java.util.Optional;

public interface AtendenteService {

    Optional<Chamado> getChamadoById(Integer id);
    List<Chamado> getAllChamados();
    void deleteAllChamados();
    void deleteChamadoById(Integer id);
    void insertChamado(Chamado chamado);
    void deleteChamado(Chamado chamado);
    void saveChamado(Chamado chamado);
}
