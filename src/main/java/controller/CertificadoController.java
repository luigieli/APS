package controller;

import app.Session;
import service.CertificadoService;
import service.EventoService;
import service.TrabalhoService;
import view.CertificadoVisao;

public class CertificadoController {
    public CertificadoController() {
    }

    public void getParticipationCertificate(){
        try{
            var eventos = new EventoService().getAllEventsWithPresenceCertified(Session.getLoggedInUsuario());
            var eventoPresent = new CertificadoVisao().renderAllSubscribedEventsPresentView(eventos);
            new CertificadoService().generatePresenceCertificate(eventoPresent, Session.getLoggedInUsuario());
        }catch (Exception e){
            System.err.println(e.getMessage()); // TODO: PRECISA ESTAR LOGADO PARA GERAR CERTIFICADO
        }
    }

    public void getWorkApresentationCertificate(){
        try{
            var trabalhos = new TrabalhoService().getAllTrabalhosMadeByMe(Session.getLoggedInUsuario());
            var trabalhoChosen = new CertificadoVisao().renderAllWorksShowView(trabalhos);
            new CertificadoService().generateWorkShowCertificate(trabalhoChosen,trabalhoChosen.getEvento(),Session.getLoggedInUsuario());
        }catch (Exception e){
            System.err.println(e.getMessage());// TODO: PRECISA ESTAR LOGADO PARA GERAR CERTIFICADO
        }
    }
}
