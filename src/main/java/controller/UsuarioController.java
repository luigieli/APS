package controller;

import app.Session;
import model.Evento;
import service.AvaliacaoService;
import service.UsuarioService;
import view.EventoVisao;
import view.GeralVisao;
import view.TrabalhoVisao;
import view.UsuarioVisao;

public class UsuarioController {
    public UsuarioController() {
    }

    public void login(){
        String email = "";
        email = new UsuarioVisao().renderLoginView();
        var usuarioOptional = new UsuarioService().login(email);
        if(usuarioOptional.isEmpty()) {
            login();
            return;
        }
        var usuario = usuarioOptional.get();
        Session.getInstance().login(usuario);
    }

    public void cadastrar(){
        var inputs = new UsuarioVisao().renderCadastrarView();
        new UsuarioService().cadastrar(inputs);
    }

    public void registrarAvaliacao(Evento evento) {
        var trabalhoChosen = new EventoVisao().renderGetAllWorksView(evento);
        if(trabalhoChosen == null){
            return;
        }
        var input = new TrabalhoVisao().renderSetAvaliacao(trabalhoChosen);
        new AvaliacaoService().addAvaliacaoToWork(trabalhoChosen, input, Session.getLoggedInUsuario());
    }
}
