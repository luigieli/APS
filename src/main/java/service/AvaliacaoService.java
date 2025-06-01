package service;

import app.Database;
import model.Avaliacao;
import model.Trabalho;
import model.Usuario;
import repository.AvalicaoRepository;
import repository.TrabalhoRepository;
import repository.UsuarioRepository;

import java.util.ArrayList;

public class AvaliacaoService {
    private AvalicaoRepository avalicaoRepository;
    private TrabalhoRepository trabalhoRepository;
    private UsuarioRepository usuarioRepository;
    public AvaliacaoService() {
        avalicaoRepository = Database.getInstance().getAvaliacaoRepository();
        trabalhoRepository = Database.getInstance().getTrabalhoRepository();
        usuarioRepository = Database.getInstance().getUsuarioRepository();
    }

    public Boolean addAvaliacaoToWork(Trabalho trabalho, ArrayList<Object> inputs, Usuario avaliador){
        Avaliacao avaliacao = new Avaliacao((Double) inputs.get(1), (String) inputs.get(0), trabalho, avaliador);
        avaliador.getAvalicoesFeitas().add(avaliacao);
        trabalho.getAvaliacoes().add(avaliacao);
        usuarioRepository.update(avaliador);
        trabalhoRepository.update(trabalho);
        return avalicaoRepository.create(avaliacao);
    }

}
