package view;

import java.util.Scanner;

public class TemplateVisao {
    protected Scanner scanner;

    public TemplateVisao() {
        scanner = new Scanner(System.in);
    }

    public void clearScreen(){
        try {
            Runtime.getRuntime().exec("clear").waitFor();
        }catch (Exception e){
            System.out.println("meu pinto");
        }
    }
}
