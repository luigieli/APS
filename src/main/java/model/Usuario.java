package model;

import java.util.ArrayList;
import java.util.UUID;

public class Usuario {
    private UUID idUsuario;
    protected String nomeCompleto;
    protected String email;
    protected String role;
    protected ArrayList<Inscricao> inscricoes;
    protected ArrayList<Trabalho> trabalhos;
    protected ArrayList<Certificado> certificados;

    public Usuario() {
        this.idUsuario = UUID.randomUUID();
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Usuario(String nomeCompleto, String email, String role) {
        this.idUsuario = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.role = role;
    }

    public ArrayList<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(ArrayList<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(ArrayList<Certificado> certificados) {
        this.certificados = certificados;
    }
}
