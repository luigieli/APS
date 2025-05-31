package service;

import app.Database;
import app.Session;
import model.Evento;
import repository.EventoRepository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class EventoService {
    private EventoRepository eventoRepository;

    public EventoService() {
        this.eventoRepository = Database.getInstance().getEventoRepository();
    }

    public ArrayList<Evento> GetAllEvents(){
        return eventoRepository.getAll();
    }

    public Optional<Evento> getEvent(UUID id){
        return eventoRepository.getById(id);
    }
}
