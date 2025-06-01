package view;

import model.Trabalho;

import java.util.ArrayList;
import java.util.Arrays;

public class TrabalhoVisao extends TemplateVisao{

    public TrabalhoVisao() {
        super();
    }

    public ArrayList<String> renderSubmitView(){
        clearScreen();
        System.out.println("###################################");
        System.out.println("Submissão de Trabalho");
        System.out.println("###################################");
        System.out.println("Insira o URL do trabalho: ");
        var url = scanner.next();
        scanner.nextLine();
        System.out.println("Insira o título do trabalho: ");
        var titulo = scanner.nextLine();
        System.out.println("Insira o tipo de trabalho: ");
        var tipo = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(titulo, tipo, url));
    }

    public ArrayList<Object> renderSetAvaliacao(Trabalho trabalho){
        clearScreen();
        System.out.println("###################################");
        System.out.println("Avaliação de Trabalho");
        System.out.println("Trabalho: " + trabalho.getTitulo());
        System.out.println("###################################");
        System.out.println("Insira o seu comentário: ");
        var comment = scanner.nextLine();
        System.out.println("Insira sua nota (ex: 4.6): ");
        Double nota = scanner.nextDouble();
        return new ArrayList<>(Arrays.asList(comment,nota));
    }

}
