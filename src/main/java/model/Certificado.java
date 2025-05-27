package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Certificado {
    protected String tipo;
    protected String codigoDeValidacao;
    protected LocalDate data;
    private UUID idCertificado;
    protected Usuario usuario;
    protected Evento evento;
    protected ArrayList<Trabalho> trabalhos;

    public Certificado(String tipo, String codigoDeValidacao, LocalDate data) {
        this.tipo = tipo;
        this.codigoDeValidacao = codigoDeValidacao;
        this.data = data;
    }

    public Certificado(String tipo, String codigoDeValidacao, LocalDate data, Evento evento) {
        this.tipo = tipo;
        this.codigoDeValidacao = codigoDeValidacao;
        this.data = data;
        this.evento = evento;
    }

    public Certificado(LocalDate data, Usuario usuario, String codigoDeValidacao, String tipo) {
        this.data = data;
        this.usuario = usuario;
        this.codigoDeValidacao = codigoDeValidacao;
        this.tipo = tipo;
    }

    public Certificado() {
        this.idCertificado = UUID.randomUUID();
    }

    public Certificado(String tipo, String codigoDeValidacao, LocalDate data, Usuario usuario, Evento evento) {
        this.idCertificado = UUID.randomUUID();
        this.tipo = tipo;
        this.codigoDeValidacao = codigoDeValidacao;
        this.data = data;
        this.usuario = usuario;
        this.evento = evento;
    }

    public String getTipo() {
        return tipo;
    }

    public UUID getIdCertificado() {
        return idCertificado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(ArrayList<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public String getCodigoDeValidacao() {
        return codigoDeValidacao;
    }

    public void setCodigoDeValidacao(String codigoDeValidacao) {
        this.codigoDeValidacao = codigoDeValidacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
