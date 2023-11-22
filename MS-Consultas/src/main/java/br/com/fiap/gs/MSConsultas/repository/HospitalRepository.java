package br.com.fiap.gs.MSConsultas.repository;

import br.com.fiap.gs.MSConsultas.model.Consulta;
import br.com.fiap.gs.MSConsultas.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> { }
