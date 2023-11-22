package br.com.fiap.gs.MSConsultas.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String exame;

    @OneToOne(targetEntity = Paciente.class)
    Paciente paciente;

    @OneToOne(targetEntity = Hospital.class)
    Hospital hospital;

    @OneToOne(targetEntity = Funcionario.class)
    Funcionario funcionario;

    Date dataExame;

    String diagnostico;

    String receita;

    @Enumerated(EnumType.STRING)
    StatusEnum status = StatusEnum.MARCADO;

    public Consulta() {
    }

    public Consulta(Long id, String exame, Paciente paciente, Hospital hospital, Funcionario funcionario, Date dataExame, String diagnostico, String receita, StatusEnum status) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
