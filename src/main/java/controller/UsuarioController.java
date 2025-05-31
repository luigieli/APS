package controller;

import app.Session;
import service.UsuarioService;
import view.UsuarioVisao;

public class UsuarioController {
    private Session usuarioSession;

    public UsuarioController() {
        usuarioSession = new Session(null);
    }

    public void login(){
        String email = "";
        do{
            email = new UsuarioVisao().renderLoginView();
        }while (!new UsuarioService(usuarioSession).login(email));

    }

    public void cadastrar(){

    }
}
