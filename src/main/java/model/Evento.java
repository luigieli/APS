package model;

import subtypes.Endereco;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

public class Evento {
    private UUID idEvento;
    protected String nome;
    protected String descricao;
    protected LocalDate dataInicio;
    protected LocalDate dataFim;
    protected Endereco local;
    protected Integer capacidadeMax;
    protected Integer capacidadeAtual;
    protected LocalDate periodoSubmissao;
    protected Usuario organizador;
    protected Integer diasCancelarInscricao;
    protected ArrayList<Inscricao> inscricoes;
    protected ArrayList<Usuario> avaliadores;
    protected ArrayList<Trabalho> trabalhos;

    public Evento() {
        this.idEvento = UUID.randomUUID();
    }

    public Evento(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim, Endereco local, Integer capacidadeMax, LocalDate periodoSubmissao, Usuario organizador, Integer diasCancelarInscricao) {
        this.idEvento = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        this.capacidadeMax = capacidadeMax;
        this.capacidadeAtual = 0;
        this.periodoSubmissao = periodoSubmissao;
        this.organizador = organizador;
        this.diasCancelarInscricao = diasCancelarInscricao;
        this.inscricoes = new ArrayList<>();
        this.avaliadores = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
    }

    public Evento(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim, Endereco local, Integer capacidadeMax, LocalDate periodoSubmissao, Integer diasCancelarInscricao) {
        this.idEvento = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        this.capacidadeMax = capacidadeMax;
        this.capacidadeAtual = 0;
        this.periodoSubmissao = periodoSubmissao;
        this.diasCancelarInscricao = diasCancelarInscricao;
        this.inscricoes = new ArrayList<>();
        this.avaliadores = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Endereco getLocal() {
        return local;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
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

    public Integer getDiasCancelarInscricao() {
        return diasCancelarInscricao;
    }

    public void setDiasCancelarInscricao(Integer diasCancelarInscricao) {
        this.diasCancelarInscricao = diasCancelarInscricao;
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
}
