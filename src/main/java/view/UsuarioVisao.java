package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UsuarioVisao extends TemplateVisao{

    public UsuarioVisao() {
        super();
    }

    public String renderLoginView(){
        clearScreen();
        System.out.println("###################################");
        System.out.print("Email: ");
        var email = scanner.nextLine();
        System.out.println("###################################");
        return email;
    }
    public ArrayList<String> renderCadastrarView(){
        clearScreen();
        System.out.println("###################################");
        System.out.print("Email: ");
        var email = scanner.nextLine();
        System.out.println("Nome completo: ");
        var nome = scanner.nextLine();
        System.out.println("Instituição: ");
        var instituicao = scanner.nextLine();
        System.out.println("###################################");
        return new ArrayList<>(Arrays.asList(email,nome,instituicao));
    }

}
