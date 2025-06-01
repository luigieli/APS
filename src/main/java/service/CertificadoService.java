package service;

import app.Database;
import model.Certificado;
import model.Evento;
import model.Usuario;
import repository.CertificadoRepository;

import java.time.LocalDate;
import java.util.UUID;

public class CertificadoService {
    CertificadoRepository certificadoRepository;

    public CertificadoService() {
        this.certificadoRepository = Database.getInstance().getCertificadoRepository();
    }

    public String generateCertifyCode(){
        return UUID.randomUUID().toString();
    }

    public Boolean generatePresenceCertificate(Evento evento, Usuario usuario){
        return certificadoRepository.create(new Certificado("PRESENÇA", generateCertifyCode(), evento.getDataInicio(), usuario, evento));
    }
}
