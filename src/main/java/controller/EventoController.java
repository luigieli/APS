package controller;

import app.Session;
import model.Evento;
import service.EventoService;
import service.InscricaoService;
import subtypes.Endereco;
import view.EventoVisao;
import view.GeralVisao;

import java.time.LocalDate;

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
        var choice = new EventoVisao().renderEventView(evento);
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
            case 4 -> {
                try{
                    new UsuarioController().registrarAvaliacao(evento);
                    getAllEvents();
                }catch (Exception e){
                    e.getMessage(); //TODO: TRATAR ESTAR LOGADO PARA AVALIAR TRABALHOS
                }
            }
        }
    }

    public void createEvent() throws Exception{
        var eventoBuilder = new EventoVisao().renderCreateEventView();
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

    public void setAppraiserToEvent(Evento evento) throws Exception{
        var appraiseEmail = new EventoVisao().renderSelectAppraiserView(evento);
        new EventoService().addAppraiserToEvent(evento, appraiseEmail);
    }

    public void updateEvent(Evento evento) throws Exception{
        var choices = new EventoVisao().renderUpdateEventView(evento);
        var eventoUpdated = new EventoService().updateEvent(choices,evento);
        if(eventoUpdated.isEmpty()) throw new Exception("Evento não encontrado.");
    }

    public void viewMyEvent(Evento evento){
        var choice = new EventoVisao().renderMyEventView(evento);
        switch (choice){
            case 0 -> getAllMyEvents();
            case 1 -> {
                new InscricaoController().lancarPresenca(evento);
                getAllMyEvents();
            }
            case 2 -> {
                try{
                    setAppraiserToEvent(evento);
                    getAllMyEvents();
                }catch (Exception e){
                    e.getMessage(); // TODO: AVALIADOR NÃO ENCONTRADO
                }
            }
            case 3 -> {
                try{
                    updateEvent(evento);
                    getAllMyEvents();
                }catch (Exception e){
                   e.getMessage(); // TODO: EVENTO NÃO ENCONTRADO
                }
            }
        }
    }

}
