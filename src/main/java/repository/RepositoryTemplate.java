package repository;

import model.Trabalho;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryTemplate<T> {
    public ArrayList<T> getAll();
    public Boolean delete(UUID id);
    Optional<T> update(T entity);
    public Optional<T> getById(UUID id);
    public Boolean create(T entity);
}
