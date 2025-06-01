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
            if(eventoPresent == null) return;
            var certificado = new CertificadoService().generatePresenceCertificate(eventoPresent, Session.getLoggedInUsuario());
            new CertificadoVisao().renderCertificatePresence(certificado);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void getWorkApresentationCertificate(){
        try{
            var trabalhos = new TrabalhoService().getAllTrabalhosMadeByMe(Session.getLoggedInUsuario());
            var trabalhoChosen = new CertificadoVisao().renderAllWorksShowView(trabalhos);
            if (trabalhoChosen == null) return;
            var certificado = new CertificadoService().generateWorkShowCertificate(trabalhoChosen,trabalhoChosen.getEvento(),Session.getLoggedInUsuario());
            new CertificadoVisao().renderCertificateWorkShow(certificado);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
