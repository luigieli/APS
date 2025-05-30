package repository;

import model.Trabalho;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class TrabalhoRepository implements RepositoryTemplate<Trabalho>{
    private ArrayList<Trabalho> trabalhos;

    public TrabalhoRepository() {
        this.trabalhos = new ArrayList<>();
    }

    @Override
    public ArrayList<Trabalho> getAll() {
        return this.trabalhos;
    }

    @Override
    public Boolean delete(UUID id) {
        this.trabalhos.removeIf(t -> {
            return t.getIdTrabalho().equals(id);
        });
        return false;
    }

    @Override
    public Optional<Trabalho> update(Trabalho trabalho){
        var trabalhoOptional = this.trabalhos.stream()
                .filter(t -> t.getIdTrabalho().equals(trabalho.getIdTrabalho()))
                .findFirst();
        if(trabalhoOptional.isEmpty()) return Optional.empty();
        var trabalhoFound = trabalhoOptional.get();
        trabalhoFound = (Trabalho)trabalho;
        return Optional.of(trabalhoFound);
    }

    @Override
    public Optional<Trabalho> getById(UUID id) {
        return this.trabalhos.stream()
                .filter(t -> t.getIdTrabalho().equals(id))
                .findFirst();
    }

    @Override
    public Boolean create(Trabalho trabalho) {
        return this.trabalhos.add(trabalho);
    }
}
