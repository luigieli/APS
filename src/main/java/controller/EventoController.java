package controller;

import app.Session;
import service.EventoService;
import service.InscricaoService;
import service.TrabalhoService;
import view.EventoVisao;

import java.util.UUID;

public class EventoController {

    private Session usuarioSession;

    public EventoController(Session session) {
        usuarioSession = new Session(session.getUsuarioSession());
    }

    public void getAllEvents(){
        var eventos = new EventoService().GetAllEvents();
        var eventoId = new EventoVisao().renderAllEvents(eventos);
        viewEvent(eventoId);
    }

    public void viewEvent(UUID id){
        var eventoOptional = new EventoService().getEvent(id);
        if(eventoOptional.isEmpty()) getAllEvents();
        var eventoFound = eventoOptional.get();
        var choice = new EventoVisao().renderViewEvent(eventoFound);
        switch (choice){
            case 1 -> {
                try{
                    new InscricaoService().realizarInscricao(eventoFound,usuarioSession.getUsuarioSession());
                    getAllEvents();
                }catch (Exception e){
                     e.getMessage(); // TODO: TRATAR EXIBIÇÃO DE MENSAGENS DE ERRO NA INTERFACE
                     viewEvent(id);
                }
            }
            case 2 -> {
                new TrabalhoController(usuarioSession).submeterTrabalho(eventoFound);
            }
            case 3 -> {
                // TODO: CANCELAR INSCRIÇÃO
            }
        }
    }
}
