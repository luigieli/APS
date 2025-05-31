package controller;

import app.Session;
import model.Evento;
import model.Trabalho;
import service.TrabalhoService;
import subtypes.URL;
import view.TrabalhoVisao;

public class TrabalhoController {
    private Session usuarioSession;

    public TrabalhoController(Session session) {
        usuarioSession = new Session(session.getUsuarioSession());
    }
    public void submeterTrabalho(Evento evento){
        var inputs = new TrabalhoVisao().renderSubmitView();
        try{
            new TrabalhoService().createTrabalho(
                    new Trabalho(inputs.get(0), inputs.get(1), new URL(inputs.get(2))),
                    evento,
                    usuarioSession.getUsuarioSession()
            );
        }catch (Exception e){
            e.getMessage(); // TODO: TRATAR EXIBIÇÃO DE MENSAGENS DE ERRO NA INTERFACE
        }

    }
}
