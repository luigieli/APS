package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Inscricao {
    private UUID idInscricao;
    protected LocalDateTime data;
    protected String status;
    protected Evento evento;
    protected Usuario usuario;
    protected ArrayList<Trabalho> trabalhos;

    public Inscricao() {
        this.idInscricao = UUID.randomUUID();
    }

    public Inscricao(LocalDateTime data, String status, Evento evento, Usuario usuario, ArrayList<Trabalho> trabalhos) {
        this.idInscricao = UUID.randomUUID();
        this.data = data;
        this.status = status;
        this.evento = evento;
        this.usuario = usuario;
        this.trabalhos = trabalhos;
    }

    public Inscricao(LocalDateTime data, String status, Evento evento, Usuario usuario) {
        this.idInscricao = UUID.randomUUID();
        this.data = data;
        this.status = status;
        this.evento = evento;
        this.usuario = usuario;
    }

    public ArrayList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(ArrayList<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
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
