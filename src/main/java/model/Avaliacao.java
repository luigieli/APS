package model;

import java.util.ArrayList;
import java.util.UUID;

public class Avaliacao {
    private UUID idAvaliacao;
    protected Double nota;
    protected String comentario;
    protected Trabalho trabalho;
    protected Usuario avaliador;

    public Avaliacao() {
        this.idAvaliacao = UUID.randomUUID();
    }

    public Avaliacao(Double nota, String comentario, Trabalho trabalho, Usuario avaliador) {
        this.nota = nota;
        this.comentario = comentario;
        this.trabalho = trabalho;
        this.avaliador = avaliador;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public UUID getIdAvaliacao() {
        return idAvaliacao;
    }

    public Usuario getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Usuario avaliador) {
        this.avaliador = avaliador;
    }

    public void setIdAvaliacao(UUID idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
