package app;

import model.Usuario;

public class Session {
    private static Usuario usuario;


    public static Usuario getInstance(Usuario usuario) {
        if (usuario == null) {
            Session.usuario = usuario;
        }
        return Session.usuario;
    }

    public static Usuario getUsuarioInstance() throws Exception{
        if (usuario == null) {
            throw new Exception("Você não está logado.");
        }
        return Session.usuario;
    }

    public Session(Usuario usuario) {
        Session.usuario = usuario;
    }

    public void setUsuario(Usuario usuario) {
        Session.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
