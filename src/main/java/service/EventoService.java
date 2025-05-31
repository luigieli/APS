package service;

import app.Database;
import model.Evento;
import model.Usuario;
import repository.EventoRepository;

import java.util.ArrayList;
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
}
