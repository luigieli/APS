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
        if(evento.getCapacidadeAtual().equals(evento.getCapacidadeMax())) throw new Exception("Capacidade máxima atingida.");
        var data = LocalDate.now();
        if(data.isAfter(evento.getDataInicio())) throw new Exception("Prazo para inscrição já acabou.");
        inscricaoRepository.create(new Inscricao(
                data,
                "INSCRITO",
                evento,
                usuario
        ));
        evento.setCapacidadeAtual(evento.getCapacidadeAtual()+1);
        return true;
    }

    public Boolean cancelarInscricao(Evento evento, Usuario usuario) throws Exception{
        var inscricaoOptional = inscricaoRepository.getByUserIdAndEventId(evento.getIdEvento(), usuario.getIdUsuario());
        if(inscricaoOptional.isEmpty()) throw new Exception("Você não está inscrito para o evento: " + evento.getNome());
        var inscricaoFound = inscricaoOptional.get();
        inscricaoRepository.delete(inscricaoFound.getIdInscricao());
        evento.getInscricoes().removeIf(i -> i.getIdInscricao().equals(inscricaoFound.getIdInscricao()));
        eventoRepository.update(evento);
        usuario.getInscricoes().removeIf(i -> i.getIdInscricao().equals(inscricaoFound.getIdInscricao()));
        usuarioRepository.update(usuario);
        return true;
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
