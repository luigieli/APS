package model;

import subtypes.URL;

import java.util.ArrayList;
import java.util.UUID;

public class Trabalho {
    private UUID idTrabalho;
    protected String titulo;
    protected String tipo;
    protected String status;
    protected URL arquivo;
    protected ArrayList<Avaliacao> avaliacoes;
    protected Evento evento;
    protected ArrayList<Inscricao> inscricoes;
    protected ArrayList<Certificado> certificados;

    public Trabalho() {
        this.idTrabalho = UUID.randomUUID();
    }

    public Trabalho(String titulo, String tipo, String status, URL arquivo, ArrayList<Avaliacao> avaliacoes, Evento evento, ArrayList<Inscricao> inscricoes, ArrayList<Certificado> certificados) {
        this.idTrabalho = UUID.randomUUID();
        this.titulo = titulo;
        this.tipo = tipo;
        this.status = status;
        this.arquivo = arquivo;
        this.avaliacoes = avaliacoes;
        this.evento = evento;
        this.inscricoes = inscricoes;
        this.certificados = certificados;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public UUID getIdTrabalho() {
        return idTrabalho;
    }

    public ArrayList<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(ArrayList<Certificado> certificados) {
        this.certificados = certificados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public URL getArquivo() {
        return arquivo;
    }

    public void setArquivo(URL arquivo) {
        this.arquivo = arquivo;
    }
}
