package view;

import model.Evento;
import model.Inscricao;
import subtypes.Endereco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class EventoVisao extends TemplateVisao{
    public EventoVisao() {
        super();
    }

    public Evento renderAllEvents(ArrayList<Evento> eventos){
        System.out.println("Eventos:");
        System.out.println("###################################");
        for(int i=0; i < eventos.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println("Opção: " + i+1);
            System.out.println("Nome: " + eventos.get(i).getNome());
            System.out.println("Descrição: " + eventos.get(i).getDescricao());
            System.out.println("Data de início do evento: " + eventos.get(i).getDataInicio());
            System.out.println("Data de término do evento: " + eventos.get(i).getDataFim());
            System.out.println("Local:" + eventos.get(i).getLocal());
            System.out.println("Perído de submissão: " + eventos.get(i).getPeriodoSubmissao());
            System.out.println("Número de inscritos: " + eventos.get(i).getCapacidadeAtual() + " | "
                    + "Limite máximo: " + eventos.get(i).getCapacidadeMax());
            System.out.println("-----------------------------------");
        }
        System.out.println("0 - VOLTAR.");
        System.out.println("###################################");
        System.out.print("Selecione: ");
        var choice = scanner.nextInt();
        if (choice == 0){
            return null;
        }
        return eventos.get(choice-1);
    }

    public Integer renderViewEvent(Evento evento){
        System.out.println("###################################");
        System.out.println("-----------------------------------");
        System.out.println("Nome: " + evento.getNome());
        System.out.println("Descrição: " + evento.getDescricao());
        System.out.println("Data do evento: " + evento.getDataInicio());
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
        System.out.println("0 - VOLTAR.");
        System.out.println("###################################");
        System.out.print("Selecione a opção desejada: ");
        return scanner.nextInt();
    }

    public ArrayList<Object> renderCreateEvent(){
        System.out.println("###################################");
        System.out.println("Insira o nome do evento: ");
        var nome = scanner.next();
        System.out.println("Insira a descrição do evento: ");
        var descricao = scanner.next();
        System.out.println("Insira a quantidade máxima de participantes: ");
        Integer capacidadeMax = scanner.nextInt();
        System.out.println("Insira a data de início do evento (DD/MM/YYYY): ");
        var dataInicioStr = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var dataInicio = LocalDate.parse(dataInicioStr,formatter);
        System.out.println("Insira a data de término do evento (DD/MM/YYYY): ");
        var dataFimStr = scanner.next();
        var dataFim = LocalDate.parse(dataFimStr,formatter);
        System.out.println("Insira o prazo máximo para submeter trabalhos (DD/MM/YYYY): ");
        var dataTrabStr = scanner.next();
        var dataTrab = LocalDate.parse(dataTrabStr, formatter);
        System.out.println("Insira o CEP de onde será o evento: ");
        var cep = scanner.next();
        System.out.println("Insira a UF de onde será o evento: ");
        var uf = scanner.next();
        System.out.println("Insira a cidade de onde será o evento: ");
        var cidade = scanner.next();
        System.out.println("Insira o bairro de onde será o evento: ");
        var bairro = scanner.next();
        System.out.println("Insira a rua de onde será o evento: ");
        var rua = scanner.next();
        System.out.println("Insira o número do logradouro de onde será o evento: ");
        Integer numero = scanner.nextInt();
        System.out.println("###################################");
        Endereco endereco = new Endereco(numero,rua,cidade,bairro,uf,cep);
        return new ArrayList<>(Arrays.asList(nome, descricao, dataInicio, dataFim, endereco, capacidadeMax, dataTrab));
    }

    public String renderSubscribedView(ArrayList<Inscricao> inscritos){
        ArrayList<Inscricao> presents = new ArrayList<>();
        System.out.println("###################################");
        for(int i=0; i < inscritos.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println((i+1) + " - Inscrito: " + inscritos.get(i).getUsuario().getNomeCompleto());
            System.out.println("-----------------------------------");
        }
        System.out.println("###################################");
        System.out.println("Insira os índices de cada participante presente (separado por espaço): ");
        return scanner.nextLine();
    }

    public Evento renderMyEventsView(ArrayList<Evento> eventos){
        System.out.println("###################################");
        for(int i=0; i < eventos.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println((i + 1) + " - Nome: " + eventos.get(i).getNome());
            System.out.println("Descrição: " + eventos.get(i).getDescricao());
            System.out.println("Data do evento: " + eventos.get(i).getDataInicio());
            System.out.println("Local:" + eventos.get(i).getLocal());
            System.out.println("Perído de submissão: " + eventos.get(i).getPeriodoSubmissao());
            System.out.println("Número de inscritos: " + eventos.get(i).getCapacidadeAtual() + " | "
                    + "Limite máximo: " + eventos.get(i).getCapacidadeMax());
            System.out.println("-----------------------------------");
        }
        System.out.println("###################################");
        System.out.println("Selecione o evento: (0 para VOLTAR)");
        var choice = scanner.nextInt();
        if (choice == 0) return null;
        return eventos.get(choice-1);
    }

    public Integer renderViewMyEvent(Evento evento){
        System.out.println("###################################");
        System.out.println("-----------------------------------");
        System.out.println("Nome: " + evento.getNome());
        System.out.println("Descrição: " + evento.getDescricao());
        System.out.println("Data do evento: " + evento.getDataInicio());
        System.out.println("Local:" + evento.getLocal());
        System.out.println("Perído de submissão: " + evento.getPeriodoSubmissao());
        System.out.println("Número de inscritos: " + evento.getCapacidadeAtual() + " | "
                + "Limite máximo: " + evento.getCapacidadeMax());
        System.out.println("-----------------------------------");
        System.out.println("###################################");
        System.out.println();
        System.out.println("###################################");
        System.out.println("1 - Lançar Presenca");
        System.out.println("2 - Designar Avaliador");
        System.out.println("0 - VOLTAR.");
        System.out.println("###################################");
        System.out.print("Selecione a opção desejada: ");
        return scanner.nextInt();
    }
}
