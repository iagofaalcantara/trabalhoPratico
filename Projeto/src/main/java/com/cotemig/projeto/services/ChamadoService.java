package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Chamado;

import java.util.List;

public interface ChamadoService {
    Chamado getChamadoById(Integer id);

    List<Chamado> getAllChamados();

    void deleteAllChamados();

    void deleteChamadoById(Integer id);

    void saveChamado(Chamado chamado);
}
