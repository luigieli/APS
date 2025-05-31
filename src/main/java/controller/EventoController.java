package controller;

import app.Session;
import model.Evento;
import service.EventoService;
import service.InscricaoService;
import subtypes.Endereco;
import view.EventoVisao;
import view.GeralVisao;

import java.time.LocalDate;
import java.util.UUID;

public class EventoController {


    public EventoController() {
    }

    public void getAllEvents(){
        var eventos = new EventoService().getAllEvents();
        var evento = new EventoVisao().renderAllEvents(eventos);
        if(evento == null) new GeralVisao().renderHomeLoggedScreenView();
        viewEvent(evento);
    }

    public void viewEvent(Evento evento){
        var choice = new EventoVisao().renderViewEvent(evento);
        switch (choice){
            case 0 -> getAllEvents();
            case 1 -> {
                try{
                    new InscricaoService().realizarInscricao(evento, Session.getUsuarioInstance());
                    getAllEvents();
                }catch (Exception e){
                     e.getMessage(); // TODO: TRATAR EXIBIÇÃO DE MENSAGENS DE ERRO NA INTERFACE
                     viewEvent(evento);
                }
            }
            case 2 -> {
                new TrabalhoController().submeterTrabalho(evento);
                getAllEvents();
            }
            case 3 -> {
                try{
                   new InscricaoService().cancelarInscricao(evento, Session.getUsuarioInstance());
                   getAllEvents();
                }catch (Exception e){
                    e.getMessage();
                    // TODO: TRATAR ESTAR LOGADO PARA CANCELAR INSCRIÇÃO
                }
            }
        }
    }

    public void createEvent() throws Exception{
        var eventoBuilder = new EventoVisao().renderCreateEvent();
        var evento = new Evento((String)eventoBuilder.get(0),
                (String) eventoBuilder.get(1),
                (LocalDate) eventoBuilder.get(2),
                (LocalDate) eventoBuilder.get(3),
                (Endereco) eventoBuilder.get(4),
                (Integer) eventoBuilder.get(5),
                (LocalDate) eventoBuilder.get(6)
        );
        new EventoService().createEvent(Session.getUsuarioInstance(),evento);
    }

    public void getAllMyEvents(){
        try{
            var myEvents = new EventoService().getAllMyEvents(Session.getUsuarioInstance().getIdUsuario());
            var eventoChosen = new EventoVisao().renderMyEventsView(myEvents);
            if(eventoChosen == null) new GeralVisao().renderHomeLoggedScreenView();
            viewMyEvent(eventoChosen);
        }catch (Exception e){
           e.getMessage(); // TODO USUÁRIO PRECISA ESTAR LOGADO PARA GERENCIAR SEUS PRÓPRIOS EVENTOS
        }

    }

    public void viewMyEvent(Evento evento){
        var choice = new EventoVisao().renderViewMyEvent(evento);
        switch (choice){
            case 0 -> getAllMyEvents();
            case 1 -> {
                new InscricaoController().lancarPresenca(evento);
                getAllMyEvents();
            }
            case 2 -> {
                //TODO: DESIGNAR AVALIADOR
            }
        }
    }

}
