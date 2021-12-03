package novo;

public class Endereco {

    private String bairro;
    private String cep;

    //MÉTODOS ESPECIAIS

    public Endereco(String bairro,String cep) { //CONSTRUTOR
        this.bairro = bairro;
        this.cep = cep;

    }

    //MÉTODOS ACESSORES
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }


}
