package com.cotemig.projeto.repository;


import com.cotemig.projeto.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("administradorRepository")
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

}
