package view;

import java.util.Scanner;

public class UsuarioVisao extends TemplateVisao{

    public UsuarioVisao() {
        super();
    }

    public String renderLoginView(){
        System.out.println("###################################");
        System.out.print("Email: ");
        var email = scanner.next();
        System.out.println("###################################");
        return email;
    }


}
