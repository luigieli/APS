package view;

import model.Evento;
import model.Trabalho;

import java.util.ArrayList;

public class CertificadoVisao extends GeralVisao{
    public CertificadoVisao() {
        super();
    }

    public Evento renderAllSubscribedEventsPresentView(ArrayList<Evento> eventos){
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
        if(choice==0) return null;
        return eventos.get(choice-1);
    }

    public Trabalho renderAllWorksShowView(ArrayList<Trabalho> trabalhos){
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
        if(choice==0) return null;
        return trabalhos.get(choice-1);
    }
}
