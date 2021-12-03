package novo;

public class Instrutor extends novo.Pessoa {	//A CLASSE INSTRUTOR HERDA OS ATRIBUTOS DA CLASSE PESSOA

    private String cargo;

    public Instrutor(String nome,String cpf) {		//sobrecarga
        super(nome,cpf);
    }

    public Instrutor(String nome,String cpf,String email,String celular,Endereco endereco,String cargo) {
        super(nome,cpf,email,celular, cargo, endereco);		// CHAMANDO O CONSTRUTOR DA CLASSE MAE
        this.cargo = cargo;

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return "Instrutor: " + super.getNome();
    }
}
