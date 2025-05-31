package view;

import java.util.ArrayList;
import java.util.Arrays;

public class TrabalhoVisao extends TemplateVisao{

    public TrabalhoVisao() {
        super();
    }

    public ArrayList<String> renderSubmitView(){
        System.out.println("###################################");
        System.out.println("Submissão de Trabalho");
        System.out.println("###################################");
        System.out.println("Insira o URL do trabalho: ");
        var url = scanner.next();
        System.out.println("Insira o título do trabalho: ");
        var titulo = scanner.next();
        System.out.println("Insira o tipo de trabalho: ");
        var tipo = scanner.next();
        return (ArrayList<String>) Arrays.asList(titulo, tipo, url);
    }
}
