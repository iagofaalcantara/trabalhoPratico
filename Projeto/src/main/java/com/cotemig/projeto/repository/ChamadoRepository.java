package com.cotemig.projeto.repository;

import com.cotemig.projeto.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("chamadoRepository")
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {




}
