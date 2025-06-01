package service;

import app.Database;
import model.Evento;
import model.Inscricao;
import model.Usuario;
import repository.EventoRepository;
import repository.InscricaoRepository;
import repository.UsuarioRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class EventoService {
    private EventoRepository eventoRepository;
    private UsuarioRepository usuarioRepository;
    private InscricaoRepository inscricaoRepository;

    public EventoService() {
        this.eventoRepository = Database.getInstance().getEventoRepository();
        this.usuarioRepository = Database.getInstance().getUsuarioRepository();
        this.inscricaoRepository = Database.getInstance().getInscricaoRepository();
    }

    public ArrayList<Evento> getAllEvents(){
        return eventoRepository.getAll();
    }

    public Optional<Evento> getEvent(UUID id){
        return eventoRepository.getById(id);
    }

    public Boolean createEvent(Usuario usuario, Evento evento){
        evento.setOrganizador(usuario);
        return eventoRepository.create(evento);
    }

    public ArrayList<Evento> getAllMyEvents(UUID userId){
        return eventoRepository.getAllEventsByOrganizer(userId);
    }

    public Optional<Evento> updateEvent(HashMap<String,String> changes, Evento evento){

        if(changes.containsKey("nome")){
           evento.setNome(changes.get("nome"));
        }
        if(changes.containsKey("descricao")){
            evento.setDescricao(changes.get("descricao"));
        }
        if(changes.containsKey("quantidade")){
            Integer qtd = Integer.parseInt(changes.get("quantidade"));
            evento.setCapacidadeMax(qtd);
        }
        if(changes.containsKey("dataInicio")){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            evento.setDataInicio(LocalDate.parse(changes.get("dataInicio"),formatter));
        }
        if(changes.containsKey("dataFim")){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            evento.setDataInicio(LocalDate.parse(changes.get("dataFim"),formatter));
        }
        if(changes.containsKey("prazoSubmissao")){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            evento.setDataInicio(LocalDate.parse(changes.get("prazoSubmissao"),formatter));
        }
        if(changes.containsKey("cep")){
            evento.getLocal().setCep(changes.get("cep"));
        }
        if(changes.containsKey("uf")){
            evento.getLocal().setUf(changes.get("uf"));
        }
        if(changes.containsKey("cidade")){
            evento.getLocal().setCidade(changes.get("cidade"));
        }
        if(changes.containsKey("bairro")){
            evento.getLocal().setBairro(changes.get("bairro"));
        }
        if(changes.containsKey("rua")){
            evento.getLocal().setRua(changes.get("rua"));
        }
        if(changes.containsKey("numero")){
            Integer numero = Integer.parseInt(changes.get("numero"));
            evento.setCapacidadeMax(numero);
        }

        return eventoRepository.update(evento);
    }

    public Boolean addAppraiserToEvent(Evento evento, String appraiserEmail) throws Exception{
        var appraiserOptional = usuarioRepository.getByEmail(appraiserEmail);
        if(appraiserOptional.isEmpty()){
            throw new Exception("Avaliador não encontrado.");
        }
        var appraiserFound = appraiserOptional.get();
        evento.getAvaliadores().add(appraiserFound);
        eventoRepository.update(evento);
        return true;
    }

    public ArrayList<Evento> getAllEventsWithPresenceCertified(Usuario usuario){
        var inscricoes = inscricaoRepository.getAllUserInscricoesByPresence(usuario.getIdUsuario());
        return (ArrayList<Evento>) inscricoes.stream().map(Inscricao::getEvento).collect(Collectors.toList());
    }


}
