package service;

import app.Database;
import model.Evento;
import model.Usuario;
import repository.EventoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class EventoService {
    private EventoRepository eventoRepository;

    public EventoService() {
        this.eventoRepository = Database.getInstance().getEventoRepository();
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
}
