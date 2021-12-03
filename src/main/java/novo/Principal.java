package novo;

import java.util.Scanner;
import controle.ControladorAluno;
import controle.ControladorInstrutor;

public class Principal {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in); //ler objeto tipo scanner serve para ler dados do teclado

        int opcao;	// VARIÁVEIS LOCAIS

        Aluno aluno;
        Endereco endereco;
        Instrutor instrutor;

        String antigoNome;
        String nome;
        String cpf;
        String data_nascimento;
        String bairro;
        String cep;
        String cargo;
        int escolha;

        //Pessoa p = new Instrutor("a", "a"); // polimofismo de tipo uma super classe pode  instanciar uma sub class
        //Instrutor i = new Pessoa("a", "b");  // uma sub class não pode instanciar super class
        //objetos
        ControladorAluno controladorAluno = new ControladorAluno();
        ControladorInstrutor controladorInstrutor = new ControladorInstrutor();

        do {

            System.out.println("===================================================================");
            System.out.println("\t\tSEJA BEM-VINDO(A) AO SISTEMA DE CADASTRO:\n\n\t\t1 - Aluno? Cadastre-se logo!\n\t\t2 - Instrutor? Cadastre-se de imediato!\n\t\t3 - Pesquisar cadastro por CPF.\n\t\t4 - Listar cadastro(s).\n\t\t5 - Atualizar cadastro(s).\n\t\t6 - Deletar cadastro(s). \n\t\t7 - Sair do sistema.");
            System.out.print("===================================================================\n");
            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:

                    System.out.print("==================================================================\n");
                    System.out.println("--> Informe o nome do aluno: ");
                    nome = ler.nextLine();
                    System.out.println("\n--> Informe o cpf: ");
                    cpf = ler.nextLine();
                    System.out.println("\n--> Informe a data de nascimento: ");
                    data_nascimento = ler.nextLine();
                    System.out.println("\n--> Informe o bairro que reside: ");
                    bairro = ler.nextLine();
                    System.out.println("\n--> Informe o CEP: ");
                    cep = ler.nextLine();
                    System.out.print("==================================================================\n");


                    endereco = new Endereco(bairro,cep);
                    aluno = new Aluno(nome, cpf); //excluido as outras variaveis
                    controladorAluno.cadastrarAluno(aluno);
                    System.out.println("\n");

                    break;
                case 2:

                    System.out.print("==================================================================\n");
                    System.out.println("--> Informe o nome do instrutor: ");
                    nome = ler.nextLine();
                    System.out.println("\n--> Informe o cpf: ");
                    cpf = ler.nextLine();
                    System.out.println("\n--> Informe a data de nascimento: ");
                    data_nascimento = ler.nextLine();
                    System.out.println("\n--> Informe o bairro que reside: ");
                    bairro = ler.nextLine();
                    System.out.println("\n--> Informe o CEP: ");
                    cep = ler.nextLine();
                    System.out.println("\n--> Informe o cargo:");
                    cargo = ler.nextLine();
                    System.out.print("==================================================================\n");

                    endereco = new Endereco(bairro,cep);
                    instrutor = new Instrutor(nome, cpf, data_nascimento, cargo, endereco, cargo);
                    controladorInstrutor.cadastrarInstrutor(instrutor);

                    System.out.println("\n");

                    break;

                case 3:
                    System.out.println("\n\tQual cadastro você deseja buscar? \n");
                    System.out.println("\t\t1.Buscar Cadastro do Aluno");
                    System.out.println("\t\t2.Buscar Cadastro do Instrutor");

                    escolha = ler.nextInt();
                    ler.nextLine();

                    if(escolha == 2) {
                        System.out.println("--> Digite o CPF do Instrutor desejado! \n" );
                        cpf = ler.nextLine();
                        controladorInstrutor.pesquisarInstrutor(cpf);

                    }if(escolha == 1) {
                    System.out.println("--> Digite o CPF do Aluno desejado! \n" );
                    cpf = ler.nextLine();
                    controladorAluno.pesquisarAluno(cpf);
                }
                    break;


                case 6:
                    System.out.println("\n\tQual Cadastro você deseja deletar? \n");
                    System.out.println("\t\t1.Deletar Cadastro Aluno");
                    System.out.println("\t\t2.Deletar Cadastro Instrutor");

                    escolha = ler.nextInt();
                    ler.nextLine();

                    if(escolha == 1) {
                        System.out.println("--> Digite o CPF do Aluno que você deseja deletar!" );
                        cpf = ler.nextLine();
                        controladorAluno.deletarAluno(cpf);

                    }if(escolha == 2) {
                    System.out.println("--> Digite o CPF do Instrutor que você deseja deletar!" );
                    cpf = ler.nextLine();

                    controladorInstrutor.deletarInstrutor(cpf);
                }
                    break;

                case 5:
                    System.out.println("\n\tQual Cadastro você deseja atualizar? \n");
                    System.out.println("\t\t1.Atualizar Cadastro Aluno");
                    System.out.println("\t\t2.Atualizar Cadastro Instrutor");

                    escolha = ler.nextInt();

                    if(escolha == 1) {
                        System.out.println("--> Digite o nome do Aluno que você deseja atualizar!" );
                        antigoNome = ler.nextLine();
                        ler.nextLine();
                        System.out.println("--> Digite um novo novo Nome!");
                        nome = ler.nextLine();
                        System.out.println("--> Digite um novo nova Data de Nascimento!");
                        data_nascimento = ler.nextLine();
                        System.out.println("--> Digite um novo bairro:");
                        bairro = ler.nextLine();
                        System.out.println("--> Digite um novo cep:");
                        cep = ler.nextLine();

                        endereco = new Endereco(bairro,cep);
                        controladorAluno.atualizarAluno(antigoNome, nome, data_nascimento, endereco);

                    }

                    if(escolha == 2) {
                        System.out.println("--> Digite o nome do Instrutor que você deseja atualizar: " );
                        antigoNome = ler.nextLine();
                        ler.nextLine();
                        System.out.println("--> Digite um novo novo nome: ");
                        nome = ler.nextLine();
                        System.out.println("--> Digite um novo novo email: ");
                        data_nascimento = ler.nextLine();
                        System.out.println("--> Digite um novo bairro: ");
                        bairro = ler.nextLine();
                        System.out.println("--> Digite um novo cep: ");
                        cep = ler.nextLine();
                        System.out.println("--> Digite um novo novo cargo: ");
                        cargo = ler.nextLine();

                        endereco = new Endereco(bairro,cep);
                        controladorInstrutor.atualizarInstrutor(antigoNome, nome, data_nascimento, endereco, cargo);
                        System.out.println("\n");
                    }
                    break;
                case 4:
                    System.out.println("\n\tQual Cadastro você deseja listar? \n");
                    System.out.println("\t\t1.Listar Cadastro Aluno");
                    System.out.println("\t\t2.Listar Cadastro Instrutor");

                    escolha = ler.nextInt();

                    if(escolha == 2) {

                        controladorInstrutor.listarInstrutor();
                    }if(escolha == 1) {

                    controladorAluno.listarAluno();
                }
                    break;

            }


        }
        while(opcao !=7);

    }

}