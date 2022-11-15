package com.cotemig.projeto.repository;

import com.cotemig.projeto.model.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SolicitanteRepository {
    @Repository("solicitanteRepository")
    public interface SolicitanteRepository extends JpaRepository<Solicitante, Integer> {

    }
}
