package repository;

import model.Certificado;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class CertificadoRepository implements RepositoryTemplate<Certificado> {
    private ArrayList<Certificado> certificados;

    public CertificadoRepository() {
        this.certificados = new ArrayList<>();
    }

    @Override
    public ArrayList<Certificado> getAll() {
        return this.certificados;
    }

    @Override
    public Boolean delete(UUID id) {
        return this.certificados
                .removeIf(c -> c.getIdCertificado().equals(id));
    }

    @Override
    public Optional<Certificado> update(Certificado certificado) {
        var certificadoOptional = this.certificados.stream()
                .filter(c -> c.getIdCertificado().equals(certificado.getIdCertificado()))
                .findFirst();
        if(certificadoOptional.isEmpty()) return Optional.empty();
        var certificadoFound = certificadoOptional.get();
        certificadoFound = certificado;
        return Optional.of(certificadoFound);
    }

    @Override
    public Optional<Certificado> getById(UUID id) {
        return this.certificados.stream()
                .filter(c -> c.getIdCertificado().equals(id))
                .findFirst();
    }

    @Override
    public Boolean create(Certificado certificado) {
        return this.certificados.add(certificado);
    }
}
