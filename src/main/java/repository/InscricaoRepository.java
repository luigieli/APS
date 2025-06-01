package repository;

import model.Evento;
import model.Inscricao;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class InscricaoRepository implements RepositoryTemplate<Inscricao> {
    private ArrayList<Inscricao> inscricoes;

    public InscricaoRepository() {
        this.inscricoes = new ArrayList<>();
    }

    @Override
    public ArrayList<Inscricao> getAll() {
        return this.inscricoes;
    }

    @Override
    public Boolean delete(UUID id) {
        return this.inscricoes.removeIf(i -> i.getIdInscricao().equals(id));
    }

    @Override
    public Optional<Inscricao> update(Inscricao inscricao) {
        var inscricaoOptional = this.inscricoes.stream()
                .filter(i -> i.getIdInscricao().equals(inscricao.getIdInscricao()))
                .findFirst();
        if(inscricaoOptional.isEmpty()) return Optional.empty();
        var inscricaoFound = inscricaoOptional.get();
        inscricaoFound = inscricao;
        return Optional.of(inscricaoFound);
    }

    @Override
    public Optional<Inscricao> getById(UUID id) {
        return this.inscricoes.stream().filter(u -> u.getIdInscricao().equals(id)).findFirst();
    }

    @Override
    public Boolean create(Inscricao inscricao) {
        return this.inscricoes.add(inscricao);
    }

    public Optional<Inscricao> getByUserIdAndEventId(UUID evento, UUID usuario){
        var inscricaoOptional = inscricoes.stream()
                .filter(i -> i.getUsuario().getIdUsuario().equals(usuario) && i.getEvento().getIdEvento().equals(evento))
                .findFirst();
        if(inscricaoOptional.isEmpty()) return Optional.empty();
        var inscricaoFound = inscricaoOptional.get();
        return Optional.of(inscricaoFound);
    }

    public ArrayList<Inscricao> getAllInscricoesByEventoId(UUID eventoId){
        return (ArrayList<Inscricao>) inscricoes.stream().filter(i -> i.getEvento().getIdEvento().equals(eventoId))
                .collect(Collectors.toList());
    }

    public ArrayList<Inscricao> getAllUserInscricoesByPresence(UUID userId){
        return (ArrayList<Inscricao>) this.inscricoes.stream()
                .filter(i -> i.getStatus().equals("PRESENTE") && i.getUsuario().getIdUsuario().equals(userId))
                .collect(Collectors.toList());
    }
}
