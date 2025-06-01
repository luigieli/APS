package repository;

import model.Usuario;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class UsuarioRepository implements RepositoryTemplate<Usuario> {
    private ArrayList<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public ArrayList<Usuario> getAll() {
        return this.usuarios;
    }

    @Override
    public Boolean delete(UUID id) {
        return this.usuarios
                .removeIf(u -> u.getIdUsuario().equals(id));
    }

    @Override
    public Optional<Usuario> update(Usuario usuario) {
        var usuarioOptional = this.usuarios.stream()
                .filter(u -> u.getIdUsuario().equals(usuario.getIdUsuario()))
                .findFirst();
        if(usuarioOptional.isEmpty()) return Optional.empty();
        var usuarioFound = usuarioOptional.get();
        usuarioFound = usuario;
        return Optional.of(usuarioFound);
    }

    @Override
    public Optional<Usuario> getById(UUID id) {
        return this.usuarios.stream()
                .filter(u -> u.getIdUsuario().equals(id))
                .findFirst();
    }

    @Override
    public Boolean create(Usuario usuario) {
        return this.usuarios.add(usuario);
    }

    public Optional<Usuario> getByEmail(String email){
        var usuarioOptional = this.usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
        if(usuarioOptional.isEmpty()) return Optional.empty();
        var usuarioFound = usuarioOptional.get();
        return Optional.of(usuarioFound);
    }
}
