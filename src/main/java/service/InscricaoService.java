package service;

import app.Database;
import model.Evento;
import model.Inscricao;
import model.Usuario;
import repository.EventoRepository;
import repository.InscricaoRepository;
import repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InscricaoService {
    InscricaoRepository inscricaoRepository;
    EventoRepository eventoRepository;
    UsuarioRepository usuarioRepository;
    public InscricaoService() {
        this.inscricaoRepository = Database.getInstance().getInscricaoRepository();
        this.eventoRepository = Database.getInstance().getEventoRepository();
        this.usuarioRepository = Database.getInstance().getUsuarioRepository();
    }

    public Boolean realizarInscricao(Evento evento, Usuario usuario) throws Exception{
        if(evento.getCapacidadeAtual() >= (evento.getCapacidadeMax())) throw new Exception("Capacidade máxima atingida.");
        var eventoJaInscrito = usuario.getInscricoes().stream()
                .filter(i -> i.getEvento().getIdEvento().equals(evento.getIdEvento()))
                .findFirst();
        if(eventoJaInscrito.isPresent()) throw new Exception("Você já se inscreveu para esse evento");
        var data = LocalDate.now();
        if(data.isAfter(evento.getDataInicio())) throw new Exception("Prazo para inscrição já acabou.");
        Inscricao inscricao = new Inscricao(
                data,
                "INSCRITO",
                evento,
                usuario
        );
        evento.setCapacidadeAtual(evento.getCapacidadeAtual()+1);
        evento.getInscricoes().add(inscricao);
        usuario.getInscricoes().add(inscricao);
        inscricaoRepository.create(inscricao);
        usuarioRepository.update(usuario);
        eventoRepository.update(evento);
        return true;
    }

    public Boolean cancelarInscricao(Evento evento, Usuario usuario) throws Exception{
        var inscricaoOptional = inscricaoRepository.getByUserIdAndEventId(evento.getIdEvento(), usuario.getIdUsuario());
        if(inscricaoOptional.isEmpty()) throw new Exception("Você não está inscrito para o evento: " + evento.getNome());
        var inscricaoFound = inscricaoOptional.get();
        evento.getInscricoes().removeIf(i -> i.getIdInscricao().equals(inscricaoFound.getIdInscricao()));
        evento.setCapacidadeAtual(evento.getInscricoes().size()-1);
        usuario.getInscricoes().removeIf(i -> i.getIdInscricao().equals(inscricaoFound.getIdInscricao()));
        eventoRepository.update(evento);
        usuarioRepository.update(usuario);
        return inscricaoRepository.delete(inscricaoFound.getIdInscricao());
    }

    public ArrayList<Inscricao> visualizarInscritosNoEvento(Evento evento){
        return inscricaoRepository.getAllInscricoesByEventoId(evento.getIdEvento());
    }

    public Boolean lancarPresenca(ArrayList<Inscricao> presents){
        for(var presente: presents){
            presente.setStatus("PRESENTE");
            inscricaoRepository.update(presente);
        }
        return true;
    }
}
