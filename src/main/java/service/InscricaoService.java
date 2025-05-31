package service;

import app.Database;
import model.Evento;
import model.Inscricao;
import model.Usuario;
import repository.InscricaoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InscricaoService {
    InscricaoRepository inscricaoRepository;

    public InscricaoService() {
        inscricaoRepository = Database.getInstance().getInscricaoRepository();
    }

    public Boolean realizarInscricao(Evento evento, Usuario usuario) throws Exception{
        if(evento.getCapacidadeAtual().equals(evento.getCapacidadeMax())) throw new Exception("Capacidade máxima atingida.");
        var data = LocalDate.now();
        if(data.isAfter(evento.getData())) throw new Exception("Prazo para inscrição já acabou.");
        inscricaoRepository.create(new Inscricao(
                data,
                "INSCRITO",
                evento,
                usuario
        ));
        evento.setCapacidadeAtual(evento.getCapacidadeAtual()+1);
        return true;
    }

    public InscricaoRepository getInscricaoRepository() {
        return inscricaoRepository;
    }
}
