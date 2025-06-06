package repository;

import model.Evento;
import model.Usuario;
import subtypes.Endereco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class EventoRepository implements RepositoryTemplate<Evento> {
    private ArrayList<Evento> eventos;

    public EventoRepository() {
        this.eventos = new ArrayList<>();
    }

    @Override
    public ArrayList<Evento> getAll() {
        return this.eventos;
    }

    @Override
    public Boolean delete(UUID id) {
        return this.eventos.removeIf(e -> e.getIdEvento().equals(id));
    }

    @Override
    public Optional<Evento> update(Evento evento) {
        var eventoOptional = this.eventos.stream()
                .filter(e -> e.getIdEvento().equals(evento.getIdEvento()))
                .findFirst();
        if(eventoOptional.isEmpty()) return Optional.empty();
        var eventoFound = eventoOptional.get();
        eventoFound = evento;
        return Optional.of(eventoFound);
    }

    @Override
    public Optional<Evento> getById(UUID id) {
        return this.eventos.stream()
                .filter(e -> e.getIdEvento().equals(id))
                .findFirst();
    }

    @Override
    public Boolean create(Evento evento) {
        return this.eventos.add(evento);
    }

    public ArrayList<Evento> getAllEventsByOrganizer(UUID idOrganizador){
        return (ArrayList<Evento>) this.eventos.stream()
                .filter(e -> e.getOrganizador().getIdUsuario().equals(idOrganizador))
                .collect(Collectors.toList());
    }
}
