package app;

import model.Usuario;

public class Session {
    private Usuario usuarioSession;

    public Session(Usuario usuario) {
        this.usuarioSession = usuario;
    }

    public void setUsuarioSession(Usuario usuario) {
        this.usuarioSession = usuario;
    }

    public Usuario getUsuarioSession() {
        return usuarioSession;
    }
}
