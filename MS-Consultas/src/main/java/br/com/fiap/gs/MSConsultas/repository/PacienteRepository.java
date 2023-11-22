package br.com.fiap.gs.MSConsultas.repository;

import br.com.fiap.gs.MSConsultas.model.Consulta;
import br.com.fiap.gs.MSConsultas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> { }
