package com.cotemig.projeto.repository;

import com.cotemig.projeto.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("perfilRepository")
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

    Perfil findByPerfil(String perfil);


}
