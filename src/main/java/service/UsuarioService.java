package service;

import app.Database;
import app.Session;
import model.Usuario;
import repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.Optional;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = Database.getInstance().getUsuarioRepository();
    }

    public Optional<Usuario> login(String email){
        var usuarioOptional = usuarioRepository.getByEmail(email);
        if(usuarioOptional.isEmpty()) return Optional.empty();
        var usuarioLogged = usuarioOptional.get();
        return Optional.of(usuarioLogged);
    }

    public Boolean cadastrar(ArrayList<String> data){
        return usuarioRepository.create(new Usuario(data.get(1),data.get(0),data.get(2)));
    }

}
