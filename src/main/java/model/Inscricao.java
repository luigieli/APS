package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Inscricao {
    private UUID idInscricao;
    protected LocalDate data;
    protected String status;
    protected Evento evento;
    protected Usuario usuario;
    protected Trabalho trabalho;

    public Inscricao() {
        this.idInscricao = UUID.randomUUID();
    }

    public Inscricao(String status, Evento evento, Usuario usuario, Trabalho trabalho) {
        this.idInscricao = UUID.randomUUID();
        this.data = LocalDate.now();
        this.status = status;
        this.evento = evento;
        this.usuario = usuario;
        this.trabalho = trabalho;
    }

    public Inscricao(LocalDate data, String status, Evento evento, Usuario usuario) {
        this.idInscricao = UUID.randomUUID();
        this.data = data;
        this.status = status;
        this.evento = evento;
        this.usuario = usuario;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getIdInscricao() {
        return idInscricao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
