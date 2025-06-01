package view;

import model.Certificado;
import model.Evento;
import model.Trabalho;

import java.util.ArrayList;

public class CertificadoVisao extends GeralVisao{
    public CertificadoVisao() {
        super();
    }

    public Evento renderAllSubscribedEventsPresentView(ArrayList<Evento> eventos){
        clearScreen();
        System.out.println("###################################");
        System.out.println("Eventos em que você esteve presente:");
        for(int i=0; i < eventos.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println((i+1) + " - "+ eventos.get(i).getNome());
            System.out.println("-----------------------------------");
        }
        System.out.println("###################################");
        System.out.println("Insira qual evento deseja gerar o certificado: (0 - SAIR)");
        var choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==0) return null;
        return eventos.get(choice-1);
    }

    public Trabalho renderAllWorksShowView(ArrayList<Trabalho> trabalhos){
        clearScreen();
        System.out.println("###################################");
        System.out.println("Trabalhos que você apresentou:");
        for (int i=0; i< trabalhos.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println((i+1) + " - "+ trabalhos.get(i).getTitulo()
                    + "Tipo: " + trabalhos.get(i).getTipo());
            System.out.println("-----------------------------------");
        }
        System.out.println("###################################");
        System.out.println("Insira qual trabalho deseja gerar o certificado: (0 - SAIR)");
        var choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==0) return null;
        return trabalhos.get(choice-1);
    }

    public void renderCertificatePresence(Certificado certificado){
        clearScreen();
        System.out.println("-----------------------------------");
        System.out.println("Evento: " + certificado.getEvento().getNome());
        System.out.println("Data do evento: " + certificado.getData());
        System.out.println("Código de validação: " + certificado.getCodigoDeValidacao());
        System.out.println("Nome do participante: " + certificado.getUsuario().getNomeCompleto());
        System.out.println("-----------------------------------");
    }

    public void renderCertificateWorkShow(Certificado certificado){
        clearScreen();
        System.out.println("-----------------------------------");
        System.out.println("Evento: " + certificado.getEvento().getNome());
        System.out.println("Data do evento: " + certificado.getData());
        System.out.println("Código de validação: " + certificado.getCodigoDeValidacao());
        System.out.println("Trabalho apresentado: " + certificado.getTrabalhoAvaliado().getTipo());
        System.out.println("Tipo de trabalho apresentado: " + certificado.getTrabalhoAvaliado().getTipo());
        System.out.println("Nome do participante: " + certificado.getUsuario().getNomeCompleto());
        System.out.println("-----------------------------------");
    }
}
