package br.com.fiap.gs.MSConsultas.repository;

import br.com.fiap.gs.MSConsultas.model.Consulta;
import br.com.fiap.gs.MSConsultas.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { }
