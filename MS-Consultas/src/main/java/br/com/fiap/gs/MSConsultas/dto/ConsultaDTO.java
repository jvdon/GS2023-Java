package br.com.fiap.gs.MSConsultas.dto;

import br.com.fiap.gs.MSConsultas.model.*;

import javax.persistence.JoinColumn;
import java.util.Date;

public class ConsultaDTO {
    Long id;
    String exame;
    Paciente paciente;
    Hospital hospital;
    Funcionario funcionario;
    Date dataExame;
    String diagnostico;
    String receita;

    StatusEnum status;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Consulta entity) {
        this.id = entity.getId();
        this.exame = entity.getExame();
        this.paciente = entity.getPaciente();
        this.hospital = entity.getHospital();
        this.funcionario = entity.getFuncionario();
        this.dataExame = entity.getDataExame();
        this.diagnostico = entity.getDiagnostico();
        this.receita = entity.getReceita();
        this.status = entity.getStatus();
    }

    public ConsultaDTO(Long id, String exame, Paciente paciente, Hospital hospital, Funcionario funcionario, Date dataExame, String diagnostico, String receita, StatusEnum status) {
        this.id = id;
        this.exame = exame;
        this.paciente = paciente;
        this.hospital = hospital;
        this.funcionario = funcionario;
        this.dataExame = dataExame;
        this.diagnostico = diagnostico;
        this.receita = receita;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getExame() {
        return exame;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getReceita() {
        return receita;
    }

    public StatusEnum getStatus() {
        return status;
    }
}
