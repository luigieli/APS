package repository;

import model.Inscricao;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

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
}
