package view;

import model.Evento;
import model.Inscricao;
import model.Trabalho;
import subtypes.Endereco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    public Integer renderEventView(Evento evento){
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
        System.out.println("4 - Registrar avaliação de trabalho");
        System.out.println("0 - VOLTAR.");
        System.out.println("###################################");
        System.out.print("Selecione a opção desejada: ");
        return scanner.nextInt();
    }

    public ArrayList<Object> renderCreateEventView(){
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

    public Integer renderMyEventView(Evento evento){
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

    public HashMap<String,String> renderUpdateEventView(Evento evento){
        HashMap<String, String> choice = new HashMap<>();
        Integer option;
        String optionChosen;
        while (true){
            System.out.println("###################################");
            System.out.println("-----------------------------------");
            System.out.println("Nome: " + (choice.containsKey("nome") ? choice.get("nome") : evento.getNome()));
            System.out.println("Descrição: " +  (choice.containsKey("descricao") ? choice.get("descricao") : evento.getDescricao()));
            System.out.println("Limite máximo: " +  (choice.containsKey("quantidade") ? choice.get("quantidade") : evento.getCapacidadeMax()));
            System.out.println("Data de inicio do evento: " +  (choice.containsKey("dataInicio") ? choice.get("dataInicio"):  evento.getDataInicio()));
            System.out.println("Data de fim do evento: " +  (choice.containsKey("dataFim") ? choice.get("dataFIm"):  evento.getDataInicio()));
            System.out.println("Perído de submissão: " +  (choice.containsKey("prazoSubmissao") ? choice.get("prazoSubmissao") : evento.getPeriodoSubmissao()));
            System.out.println("CEP:" +  (choice.containsKey("cep") ? choice.get("cep"):  evento.getLocal().getCep()));
            System.out.println("UF:" +  (choice.containsKey("uf") ? choice.get("uf"):  evento.getLocal().getUf()));
            System.out.println("Cidade:" +  (choice.containsKey("cidade") ? choice.get("cidade"):  evento.getLocal().getCidade()));
            System.out.println("Bairro:" +  (choice.containsKey("bairro") ? choice.get("bairro"):  evento.getLocal().getBairro()));
            System.out.println("Rua:" +  (choice.containsKey("rua") ? choice.get("rua"):  evento.getLocal().getRua()));
            System.out.println("Número:" +  (choice.containsKey("numero") ? choice.get("numero"):  evento.getLocal().getNumero()));
            System.out.println("-----------------------------------");
            System.out.println("1 -  Alterar nome do evento: ");
            System.out.println("2 -  Alterar descrição do evento: ");
            System.out.println("3 -  Alterar quantidade máxima de participantes: ");
            System.out.println("4 -  Alterar data de início do evento (DD/MM/YYYY): ");
            System.out.println("5 -  Alterar data de término do evento (DD/MM/YYYY): ");
            System.out.println("6 -  Alterar prazo máximo para submeter trabalhos (DD/MM/YYYY): ");
            System.out.println("7 -  Alterar CEP de onde será o evento: ");
            System.out.println("8 -  Alterar UF de onde será o evento: ");
            System.out.println("9 -  Alterar cidade de onde será o evento: ");
            System.out.println("10 - Alterar bairro de onde será o evento: ");
            System.out.println("11 - Alterar rua de onde será o evento: ");
            System.out.println("12 - Alterar número do logradouro de onde será o evento: ");
            System.out.println("###################################");
            System.out.println("Digite o número do campo que deseja alterar: (0 - para SAIR)");
            option = scanner.nextInt();
            System.out.println("Digite o novo valor do campo: ");
            optionChosen = scanner.nextLine();
            if(option == 1){
                choice.put("nome",optionChosen);
            }
            else if(option == 2){
                choice.put("descricao",optionChosen);
            }
            else if(option == 3){
                choice.put("quantidade",optionChosen);
            }
            else if(option == 4){
                choice.put("dataInicio",optionChosen);
            }
            else if(option == 5){
                choice.put("dataFim",optionChosen);
            }
            else if(option == 6){
                choice.put("prazoSubmissao",optionChosen);
            }
            else if(option == 7){
                choice.put("cep",optionChosen);
            }
            else if(option == 8){
                choice.put("uf",optionChosen);
            }
            else if(option == 9){
                choice.put("cidade",optionChosen);
            }
            else if(option == 10){
                choice.put("bairro",optionChosen);
            }
            else if(option == 11){
                choice.put("rua",optionChosen);
            }
            else if(option == 12){
                choice.put("Numero",optionChosen);
            }
            else if (option == 0) break;
        }
        return choice;
    }

    public String renderSelectAppraiserView(Evento evento){
        System.out.println("###################################");
        System.out.println("Designar avaliador para evento: " + evento.getNome());
        System.out.println("###################################");
        System.out.println("Insira o email do avaliador: ");
        return scanner.nextLine().toUpperCase();
    }

    public Trabalho renderGetAllWorksView(Evento evento){
        System.out.println("###################################");
        for(int i=0; i < evento.getTrabalhos().size(); i++){
            System.out.println("-----------------------------------");
            System.out.println((i+1) + " - Titulo do trabalho: " + evento.getTrabalhos().get(i).getTitulo());
            System.out.println("Tipo do trabalho: " + evento.getTrabalhos().get(i).getTipo());
            System.out.println("Arquivo: " + evento.getTrabalhos().get(i).getArquivo());
            System.out.println("-----------------------------------");
        }
        System.out.println("0 - SAIR");
        System.out.println("###################################");
        var choice = scanner.nextInt();
        if(choice == 0) return null;
        return evento.getTrabalhos().get(choice-1);
    }
}
