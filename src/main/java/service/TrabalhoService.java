package service;

import app.Database;
import app.Session;
import model.Evento;
import model.Inscricao;
import model.Trabalho;
import model.Usuario;
import repository.TrabalhoRepository;

import java.time.LocalDate;

public class TrabalhoService {
    private TrabalhoRepository trabalhoRepository;

    public TrabalhoService() {
        this.trabalhoRepository = Database.getInstance().getTrabalhoRepository();
    }

    public Boolean createTrabalho(Trabalho trabalho, Evento evento) throws Exception{
        if(LocalDate.now().isAfter(evento.getPeriodoSubmissao())) throw new Exception("Período de submissão dos trabalhos já encerrou.");
        var inscricaoOptional = Session.getUsuarioInstance().getInscricoes().stream()
                .filter(i -> i.getEvento().getIdEvento().equals(evento.getIdEvento()))
                .findFirst();
        if(inscricaoOptional.isEmpty()) throw new Exception("Você não está inscrito para o evento: " + evento.getNome());
        var inscricaoFound = inscricaoOptional.get();
        trabalho.setEvento(evento);
        trabalho.setInscricao(inscricaoFound);
        trabalho.setStatus("SUBMETIDO");
        return trabalhoRepository.create(trabalho);
    }
}
