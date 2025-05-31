package service;

import app.Database;
import app.Session;
import repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = Database.getInstance().getUsuarioRepository();
    }

    public Boolean login(String email){
        var usuarioOptional = usuarioRepository.getByEmail(email);
        if(usuarioOptional.isEmpty()) return false;
        var usuarioLogged = usuarioOptional.get();
        Session.getInstance(usuarioLogged);
        return true;
    }

}
