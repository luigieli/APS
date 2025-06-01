package controller;

import app.Session;
import model.Avaliacao;
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
        do{
            email = new UsuarioVisao().renderLoginView();
        }while (!new UsuarioService().login(email));

    }

    public void cadastrar(){

    }

    public void registrarAvaliacao(Evento evento) throws Exception{
        var trabalhoChosen = new EventoVisao().renderGetAllWorksView(evento);
        if(trabalhoChosen == null){
            new GeralVisao().renderHomeLoggedScreenView();
            return;
        }
        var input = new TrabalhoVisao().renderSetAvaliacao(trabalhoChosen);
        new AvaliacaoService().addAvaliacaoToWork(trabalhoChosen, input, Session.getUsuarioInstance());
    }
}
