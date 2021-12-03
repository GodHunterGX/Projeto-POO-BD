package novo;

public abstract class Pessoa { //CLASSE ABSTRATA

    private String nome;
    private String cpf;
    private String data_nascimento;
    private String sexo;
    private Endereco endereco;

    public Pessoa(String nome,String cpf) { //CONSTRUTOR SERVIRÁ PARA O INSTRUTOR
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String nome,String cpf,String data_nascimento,String sexo,String celular,Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.endereco = endereco;  // agregação
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }


    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }


}
