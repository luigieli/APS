package controller;

import app.Session;
import model.Evento;
import model.Inscricao;
import service.InscricaoService;
import view.EventoVisao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class InscricaoController {

    public void lancarPresenca(Evento evento) {
        ArrayList<Inscricao> inscritos = new InscricaoService().visualizarInscritosNoEvento(evento);
        var input = new EventoVisao().renderSubscribedView(inscritos);
        if(input.equals("0")) return;
        ArrayList<Integer> indicesPresentes = (ArrayList<Integer>) Arrays.stream(input.split(" "))
                .map(a -> (Integer.parseInt(a) - 1))
                .collect(Collectors.toList());

        ArrayList<Inscricao> presents = new ArrayList<>();
        for(int i=0; i < indicesPresentes.size(); i++){
            presents.add(inscritos.get(indicesPresentes.get(i)));
        }
        new InscricaoService().lancarPresenca(presents);
    }
}
