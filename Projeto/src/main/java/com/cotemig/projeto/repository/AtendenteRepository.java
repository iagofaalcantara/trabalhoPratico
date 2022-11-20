package com.cotemig.projeto.repository;

import com.cotemig.projeto.model.Atendente;
import com.cotemig.projeto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("atendenteRepository")
public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {


}
