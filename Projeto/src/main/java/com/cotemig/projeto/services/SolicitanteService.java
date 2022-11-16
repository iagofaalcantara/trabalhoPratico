package com.cotemig.projeto.services;

import com.cotemig.projeto.model.Solicitante;

import java.util.List;

public interface SolicitanteService {
    void saveSolicitante(Solicitante solicitante);

    void deleteSolicitante(Solicitante solicitante);

    public List<Solicitante> getAllSolicitantes();
}
