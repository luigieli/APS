package model;

import java.net.URI;
import java.util.ArrayList;
import java.util.UUID;

public class Trabalho {
    private UUID idTrabalho;
    protected String titulo;
    protected String tipo;
    protected String status;
    protected URI arquivo;
    protected ArrayList<Avaliacao> avaliacoes;
    protected ArrayList<Usuario> autores;
    protected ArrayList<Certificado> certificados;

    public Trabalho() {
        this.idTrabalho = UUID.randomUUID();
    }

    public Trabalho(String titulo, String tipo, String status, URI arquivo, ArrayList<Avaliacao> avaliacoes) {
        this.idTrabalho = UUID.randomUUID();
        this.titulo = titulo;
        this.tipo = tipo;
        this.status = status;
        this.arquivo = arquivo;
        this.avaliacoes = avaliacoes;
    }

    public ArrayList<Usuario> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Usuario> autores) {
        this.autores = autores;
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

    public URI getArquivo() {
        return arquivo;
    }

    public void setArquivo(URI arquivo) {
        this.arquivo = arquivo;
    }
}
