package com.cotemig.projeto.repository;

import com.cotemig.projeto.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("chamadoRepository")
@Transactional
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {


List<Chamado> findByToldAtribuido(Integer id);

}
