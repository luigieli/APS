package service;

import app.Database;
import model.Certificado;
import model.Evento;
import model.Trabalho;
import model.Usuario;
import repository.CertificadoRepository;
import repository.TrabalhoRepository;
import repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.UUID;

public class CertificadoService {
    CertificadoRepository certificadoRepository;
    TrabalhoRepository trabalhoRepository;
    UsuarioRepository usuarioRepository;
    public CertificadoService() {
        this.certificadoRepository = Database.getInstance().getCertificadoRepository();
        this.trabalhoRepository = Database.getInstance().getTrabalhoRepository();
        this.usuarioRepository = Database.getInstance().getUsuarioRepository();
    }

    public String generateCertifyCode(){
        return UUID.randomUUID().toString();
    }

    public Boolean generatePresenceCertificate(Evento evento, Usuario usuario){
        Certificado certificado = new Certificado("PRESENÇA", generateCertifyCode(), evento.getDataInicio(), usuario, evento);
        usuario.getCertificados().add(certificado);
        usuarioRepository.update(usuario);
        return certificadoRepository.create(certificado);
    }

    public Boolean generateWorkShowCertificate(Trabalho trabalho, Evento evento, Usuario usuario){
        Certificado certificado = new Certificado("APRESENTAÇÃO",generateCertifyCode(),evento.getDataInicio(),usuario,evento,trabalho);
        trabalho.getCertificados().add(certificado);
        trabalhoRepository.update(trabalho);
        return certificadoRepository.create(certificado);
    }
}
