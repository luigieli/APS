package view;

import model.Evento;
import model.Inscricao;

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
}
