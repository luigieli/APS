package model;

import java.util.UUID;

public class Avaliacao {
    private UUID idAvaliacao;
    protected Double nota;
    protected String comentario;
    protected Trabalho trabalho;


    public Avaliacao() {
        this.idAvaliacao = UUID.randomUUID();
    }

    public Avaliacao(Double nota, String comentario, Trabalho trabalho) {
        this.idAvaliacao = UUID.randomUUID();
        this.nota = nota;
        this.comentario = comentario;
        this.trabalho = trabalho;
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
