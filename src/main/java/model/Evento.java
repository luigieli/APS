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
    protected Endereco local;
    protected Integer capacidadeMax;
    protected Integer capacidadeAtual;
    protected LocalDate periodoSubmissao;
    protected Usuario organizador;
    protected ArrayList<Inscricao> inscricoes;
    protected ArrayList<Certificado> certificados;
    protected ArrayList<Usuario> avaliadores;
    protected ArrayList<Trabalho> trabalhos;

    public Evento() {
        this.idEvento = UUID.randomUUID();
    }

    public Evento(String nome, String descricao, LocalDate data, Endereco local, Integer capacidadeMax, Integer capacidadeAtual, LocalDate periodoSubmissao, Usuario organizador, ArrayList<Inscricao> inscricoes, ArrayList<Certificado> certificados, ArrayList<Usuario> avaliadores, ArrayList<Trabalho> trabalhos) {
        this.idEvento = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.capacidadeMax = capacidadeMax;
        this.capacidadeAtual = capacidadeAtual;
        this.periodoSubmissao = periodoSubmissao;
        this.organizador = organizador;
        this.inscricoes = inscricoes;
        this.certificados = certificados;
        this.avaliadores = avaliadores;
        this.trabalhos = trabalhos;
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

    public Endereco getLocal() {
        return local;
    }

    public ArrayList<Usuario> getAvaliadores() {
        return avaliadores;
    }

    public void setAvaliadores(ArrayList<Usuario> avaliadores) {
        this.avaliadores = avaliadores;
    }

    public void setLocal(Endereco local) {
        this.local = local;
    }

    public Integer getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(Integer capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public Integer getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public void setCapacidadeAtual(Integer capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
    }

    public Usuario getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }

    public ArrayList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(ArrayList<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public LocalDate getPeriodoSubmissao() {
        return periodoSubmissao;
    }

    public void setPeriodoSubmissao(LocalDate periodoSubmissao) {
        this.periodoSubmissao = periodoSubmissao;
    }

    public ArrayList<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(ArrayList<Certificado> certificados) {
        this.certificados = certificados;
    }
}
