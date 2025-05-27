package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Inscricao {
    protected LocalDateTime data;
    protected String status;
    private UUID idInscricao;
    protected Evento evento;
    protected Usuario usuario;

    public Inscricao() {
        this.idInscricao = UUID.randomUUID();
    }

    public Inscricao(LocalDateTime data, String status, Evento evento, Usuario usuario) {
        this.idInscricao = UUID.randomUUID();
        this.data = data;
        this.status = status;
        this.evento = evento;
        this.usuario = usuario;
    }

    public Inscricao(LocalDateTime data, String status) {
        this.idInscricao = UUID.randomUUID();
        this.data = data;
        this.status = status;
    }

    public Inscricao(LocalDateTime data, String status, Evento evento) {
        this.idInscricao = UUID.randomUUID();
        this.data = data;
        this.status = status;
        this.evento = evento;
    }

    public Inscricao(LocalDateTime data, String status, Usuario usuario) {
        this.idInscricao = UUID.randomUUID();
        this.data = data;
        this.status = status;
        this.usuario = usuario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
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
