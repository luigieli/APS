package view;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TemplateVisao {
    protected Scanner scanner;
    protected DateTimeFormatter dateFormatter;
    public TemplateVisao() {
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void clearScreen(){
        try {
            Runtime.getRuntime().exec("clear").waitFor();
        }catch (Exception e){
            System.out.println("meu pinto");
        }
    }
}
