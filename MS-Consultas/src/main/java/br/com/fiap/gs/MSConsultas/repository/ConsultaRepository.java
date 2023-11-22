package br.com.fiap.gs.MSConsultas.repository;

import br.com.fiap.gs.MSConsultas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> { }
