package view;

import model.Evento;

import java.util.ArrayList;
import java.util.UUID;

public class EventoVisao extends TemplateVisao{
    public EventoVisao() {
        super();
    }

    public UUID renderAllEvents(ArrayList<Evento> eventos){
        System.out.println("Eventos:");
        System.out.println("###################################");
        for(int i=0; i < eventos.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println("Opção: " + i+1);
            System.out.println("Nome: " + eventos.get(i).getNome());
            System.out.println("Descrição: " + eventos.get(i).getDescricao());
            System.out.println("Data do evento: " + eventos.get(i).getData());
            System.out.println("Local:" + eventos.get(i).getLocal());
            System.out.println("Perído de submissão: " + eventos.get(i).getPeriodoSubmissao());
            System.out.println("Número de inscritos: " + eventos.get(i).getCapacidadeAtual() + " | "
                    + "Limite máximo: " + eventos.get(i).getCapacidadeMax());
            System.out.println("-----------------------------------");
        }
        System.out.println("###################################");
        System.out.print("Selecione o evento: ");
        var choice = scanner.nextInt();
        return eventos.get(choice-1).getIdEvento();
    }

    public Integer renderViewEvent(Evento evento){
        System.out.println("###################################");
        System.out.println("-----------------------------------");
        System.out.println("Nome: " + evento.getNome());
        System.out.println("Descrição: " + evento.getDescricao());
        System.out.println("Data do evento: " + evento.getData());
        System.out.println("Local:" + evento.getLocal());
        System.out.println("Perído de submissão: " + evento.getPeriodoSubmissao());
        System.out.println("Número de inscritos: " + evento.getCapacidadeAtual() + " | "
                + "Limite máximo: " + evento.getCapacidadeMax());
        System.out.println("-----------------------------------");
        System.out.println("###################################");
        System.out.println();
        System.out.println("###################################");
        System.out.println("1 - Realizar inscrição");
        System.out.println("2 - Submeter trabalho");
        System.out.println("3 - Cancelar inscrição");
        System.out.println("###################################");
        System.out.print("Selecione a opção desejada: ");
        return scanner.nextInt();
    }

}
