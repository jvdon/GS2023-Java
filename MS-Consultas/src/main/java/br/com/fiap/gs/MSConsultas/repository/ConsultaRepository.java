package br.com.fiap.gs.MSConsultas.repository;

import br.com.fiap.gs.MSConsultas.model.Consulta;
import br.com.fiap.gs.MSConsultas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query(value = "SELECT * FROM tb_consulta WHERE paciente_cpf = ?1", nativeQuery = true)
    Consulta findByPaciente(String cpf);

    @Query(value = "SELECT * FROM tb_consulta WHERE funcionario_id = ?1", nativeQuery = true)
    Consulta findByMedico(long id);

    @Query(value = "SELECT * FROM tb_consulta WHERE dataExame = ?1", nativeQuery = true)
    Consulta findByData(Date data);

}
