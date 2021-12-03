package novo;

import java.util.Random;
import novo.Aluno;
import novo.Endereco;

public class Aluno extends Pessoa { //A CLASSE ALUNO HERDA OS ATRIBUTOS DA CLASSE PESSOA

    private int numMatricula;
    Random random = new Random(); //GERAR O NÚMERO DA MATRÍCULA DE FORMA ALEATÓRIA


    public Aluno(String nome,String cpf) { //CONSTRUTOR 1
        super(nome,cpf);
        this.numMatricula = random.nextInt(1000000);

    }

    public Aluno(String nome,String cpf,String email,String sexo,String celular,Endereco endereco) { //CONSTRUTOR 2
        super(nome,cpf,email,sexo,celular,endereco);
        this.numMatricula = random.nextInt(10000);

    }


    //MÉTODOS ACESSORES PARA TER ACESSO O ATRIBUTO MATRÍCULA

    public int getNumMatricula() {
        return numMatricula;
    }

    public String getNome() {
        return "Aluno: " + super.getNome();
    }


}