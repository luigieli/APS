package subtypes;

public class Endereco {
    protected Integer numero;
    protected String rua;
    protected String bairro;
    protected String cidade;
    protected String uf;
    protected String cep;

    public Endereco(Integer numero, String rua, String cidade, String bairro, String uf, String cep) {
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return  "   numero:" + numero + '\n'+
                "   rua: " + rua + '\n' +
                "   bairro: " + bairro + '\n' +
                "   cidade: " + cidade + '\n' +
                "   uf: " + uf + '\n' +
                "   cep: " + cep + '\n';
    }
}
