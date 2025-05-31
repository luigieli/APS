package app;

import repository.*;

public class Database {
    AvalicaoRepository avaliacaoRepository;
    CertificadoRepository certificadoRepository;
    EventoRepository eventoRepository;
    InscricaoRepository inscricaoRepository;
    TrabalhoRepository trabalhoRepository;
    UsuarioRepository usuarioRepository;
    private static Database singleton;

    public AvalicaoRepository getAvaliacaoRepository() {
        return avaliacaoRepository;
    }

    public CertificadoRepository getCertificadoRepository() {
        return certificadoRepository;
    }

    public EventoRepository getEventoRepository() {
        return eventoRepository;
    }

    public InscricaoRepository getInscricaoRepository() {
        return inscricaoRepository;
    }

    public TrabalhoRepository getTrabalhoRepository() {
        return trabalhoRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    private Database() {
        avaliacaoRepository = new AvalicaoRepository();
        certificadoRepository = new CertificadoRepository();
        eventoRepository = new EventoRepository();
        inscricaoRepository = new InscricaoRepository();
        trabalhoRepository = new TrabalhoRepository();
        usuarioRepository = new UsuarioRepository();
    }

    public static Database getInstance() {
        if (singleton == null) {
            singleton = new Database();
        }
        return singleton;
    }
}
