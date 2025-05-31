package service;

import app.Database;
import app.Session;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private Session usuarioSession;

    public UsuarioService(Session session) {
        this.usuarioSession = session;
        usuarioRepository = Database.getInstance().getUsuarioRepository();
    }

    public Boolean login(String email){
        var usuarioOptional = usuarioRepository.getByEmail(email);
        if(usuarioOptional.isEmpty()) return false;
        this.usuarioSession.setUsuarioSession(usuarioOptional.get());
        return true;
    }

}
