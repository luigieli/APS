package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Certificado {
    private UUID idCertificado;
    protected String tipo;
    protected String codigoDeValidacao;
    protected LocalDate data;
    protected Usuario usuario;
    protected Evento evento;
    protected Trabalho trabalhoAvaliado;

    public Certificado(String tipo, String codigoDeValidacao, LocalDate data, Usuario usuario, Evento evento, Trabalho trabalhoAvaliado) {
        this.idCertificado = UUID.randomUUID();
        this.tipo = tipo;
        this.codigoDeValidacao = codigoDeValidacao;
        this.data = data;
        this.usuario = usuario;
        this.evento = evento;
        this.trabalhoAvaliado = trabalhoAvaliado;
    }

    public Certificado(String tipo, String codigoDeValidacao, LocalDate data, Usuario usuario, Evento evento) {
        this.idCertificado = UUID.randomUUID();
        this.tipo = tipo;
        this.codigoDeValidacao = codigoDeValidacao;
        this.data = data;
        this.usuario = usuario;
        this.evento = evento;
    }

    public Certificado() {
        this.idCertificado = UUID.randomUUID();
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

    public Trabalho getTrabalhoAvaliado() {
        return trabalhoAvaliado;
    }

    public void setTrabalhoAvaliado(Trabalho trabalhoAvaliado) {
        this.trabalhoAvaliado = trabalhoAvaliado;
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
