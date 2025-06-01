package app;

import model.Usuario;

public class Session {
    private static Usuario loggedInUsuario;
    private static Session instance;


    private Session() {
        // Private constructor
    }
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void login(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo para login.");
        }
        Session.loggedInUsuario = usuario;
    }

    public static Usuario getLoggedInUsuario() {
        return loggedInUsuario;
    }

}
