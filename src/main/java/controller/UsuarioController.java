package controller;

import app.Session;
import model.Evento;
import service.InscricaoService;
import service.UsuarioService;
import view.UsuarioVisao;

public class UsuarioController {
    public UsuarioController() {
    }

    public void login(){
        String email = "";
        do{
            email = new UsuarioVisao().renderLoginView();
        }while (!new UsuarioService().login(email));

    }



    public void cadastrar(){

    }
}
