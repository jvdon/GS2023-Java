package br.com.fiap.gs.MSConsultas.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    @Enumerated(EnumType.STRING)
    TipoFuncionario tipoFuncionario;

    String telefone;

    @OneToOne(targetEntity = Hospital.class, fetch = FetchType.LAZY)
    Hospital hospital;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, TipoFuncionario tipoFuncionario, String telefone, Hospital hospital) {
        this.id = id;
        this.nome = nome;
        this.tipoFuncionario = tipoFuncionario;
        this.telefone = telefone;
        this.hospital = hospital;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
