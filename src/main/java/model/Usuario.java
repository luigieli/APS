package model;

import java.util.ArrayList;
import java.util.UUID;

public class Usuario {
    private UUID idUsuario;
    protected String nomeCompleto;
    protected String email;
    protected String instituicao;
    protected ArrayList<Inscricao> inscricoes;
    protected ArrayList<Trabalho> trabalhos;
    protected ArrayList<Certificado> certificados;
    protected ArrayList<Evento> eventosOrganizados;
    protected ArrayList<Avaliacao> avalicoesFeitas;

    public Usuario() {
        this.idUsuario = UUID.randomUUID();
    }

    public Usuario(String nomeCompleto, String email, ArrayList<Inscricao> inscricoes, ArrayList<Trabalho> trabalhos, ArrayList<Certificado> certificados) {
        this.idUsuario = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.inscricoes = inscricoes;
        this.trabalhos = trabalhos;
        this.certificados = certificados;
    }

    public Usuario(String nomeCompleto, String email, ArrayList<Inscricao> inscricoes, ArrayList<Certificado> certificados) {
        this.idUsuario = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.inscricoes = inscricoes;
        this.certificados = certificados;
    }

    public Usuario(String nomeCompleto, String email, String instituicao) {
        this.idUsuario = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.instituicao = instituicao;
        this.email = email;
        this.inscricoes = new ArrayList<>();
        this.eventosOrganizados = new ArrayList<>();
        this.avalicoesFeitas = new ArrayList<>();
        this.certificados = new ArrayList<>();
        this.trabalhos = new ArrayList<>();
    }

    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(ArrayList<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
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

    public ArrayList<Certificado> getCertificados() {
        return certificados;
    }

    public ArrayList<Evento> getEventosOrganizados() {
        return eventosOrganizados;
    }

    public void setEventosOrganizados(ArrayList<Evento> eventosOrganizados) {
        this.eventosOrganizados = eventosOrganizados;
    }

    public ArrayList<Avaliacao> getAvalicoesFeitas() {
        return avalicoesFeitas;
    }

    public void setAvalicoesFeitas(ArrayList<Avaliacao> avalicoesFeitas) {
        this.avalicoesFeitas = avalicoesFeitas;
    }

    public void setCertificados(ArrayList<Certificado> certificados) {
        this.certificados = certificados;
    }
}
