package model;

import subtypes.Endereco;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Evento {
    private UUID idEvento;
    protected String nome;
    protected String descricao;
    protected LocalDate data;
    protected Endereco endereco;
    protected Integer capacidade;
    protected LocalDateTime periodoSubmissao;
    protected ArrayList<Inscricao> inscricoes;
    protected ArrayList<Certificado> certificados;

    public Evento() {
        this.idEvento = UUID.randomUUID();
    }

    public Evento(String nome, String descricao, LocalDate data, Endereco endereco, Integer capacidade, LocalDateTime periodoSubmissao) {
        this.idEvento = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.endereco = endereco;
        this.capacidade = capacidade;
        this.periodoSubmissao = periodoSubmissao;
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public UUID getIdEvento() {
        return idEvento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public LocalDateTime getPeriodoSubmissao() {
        return periodoSubmissao;
    }

    public void setPeriodoSubmissao(LocalDateTime periodoSubmissao) {
        this.periodoSubmissao = periodoSubmissao;
    }

    public ArrayList<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(ArrayList<Certificado> certificados) {
        this.certificados = certificados;
    }
}
