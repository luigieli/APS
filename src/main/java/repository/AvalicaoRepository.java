package repository;

import model.Avaliacao;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class AvalicaoRepository implements RepositoryTemplate<Avaliacao> {
    private ArrayList<Avaliacao> avaliacoes;

    public AvalicaoRepository() {
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public ArrayList<Avaliacao> getAll() {
        return this.avaliacoes;
    }

    @Override
    public Boolean delete(UUID id) {
        return this.avaliacoes.removeIf(a -> a.getIdAvaliacao().equals(id));
    }

    @Override
    public Optional<Avaliacao> update(Avaliacao avaliacao) {
        var avaliacaoOptional = this.avaliacoes.stream()
                .filter(a -> a.getIdAvaliacao().equals(avaliacao.getIdAvaliacao()))
                .findFirst();
        if(avaliacaoOptional.isEmpty()) return Optional.empty();
        var avaliacaoFound = avaliacaoOptional.get();
        avaliacaoFound = avaliacao;
        return Optional.of(avaliacaoFound);
    }

    @Override
    public Optional<Avaliacao> getById(UUID id) {
        return this.avaliacoes.stream().filter(a -> a.getIdAvaliacao().equals(id))
                .findFirst();
    }

    @Override
    public Boolean create(Avaliacao avaliacao) {
        return this.avaliacoes.add(avaliacao);
    }
}
