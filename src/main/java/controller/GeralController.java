package controller;

import view.GeralVisao;

public class GeralController {
    private GeralVisao interfaceGeral;
    public GeralController() {
        interfaceGeral = new GeralVisao();
    }

    public void homeScreen(){
        var choice = interfaceGeral.renderHomeView();

        if(choice == 1){
            new UsuarioController().login();
            loggedHomeScreen();
        }else if(choice == 2){
            new UsuarioController().cadastrar();
            homeScreen();
        }else{
            System.err.println("COMANDO INVÁLIDO!!!");
            homeScreen();
        }

    }

    public void loggedHomeScreen(){
        while (true){
            var choice = interfaceGeral.renderHomeLoggedScreenView();
            switch (choice){
                case 1 -> {
                    new EventoController().getAllEvents();
                }
                case 2 -> {
                    try{
                        new EventoController().createEvent();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    new EventoController().getAllMyEvents();
                }
                case 4 -> {
                    new CertificadoController().getParticipationCertificate();
                }
                case 5 -> {
                    new CertificadoController().getWorkApresentationCertificate();
                }
            }
        }
    }


}
