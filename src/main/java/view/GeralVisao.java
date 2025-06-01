package view;


public class GeralVisao extends TemplateVisao{

    public GeralVisao() {
        super();
    }

    public int renderHomeView() {
        System.out.println("###################################");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastrar");
        System.out.println("###################################");
        return scanner.nextInt();
    }

    public Integer renderHomeLoggedScreenView(){
        System.out.println("###################################");
        System.out.println("1 - Visualizar lista de eventos disponíveis");
        System.out.println("2 - Cadastrar novo evento");
        System.out.println("3 - Gerenciar meus eventos");
        System.out.println("4 - Emitir certificado de participação");
        System.out.println("5 - Emitir certificado de apresentação");
        System.out.println("###################################");
        return scanner.nextInt();
    }

}
