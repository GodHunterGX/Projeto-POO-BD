package novo;

import controle.ControladorAluno;
import controle.ControladorInstrutor;
import novo.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Principal {

    public static void main(String[] args) throws IOException {


        Scanner ler = new Scanner(System.in); //ler objeto tipo scanner serve para ler dados do teclado
        //Para aluno
        FileWriter arq = new FileWriter("D:\\Aluno.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        //para Instrutor
        FileWriter arquivo = new FileWriter("D:\\Instrutor.txt");
        PrintWriter gravarArquivo = new PrintWriter(arquivo);

        File delFile2 = new File("D:\\Aluno.txt");
        delFile2.createNewFile();
        File delFile3 = new File("D:\\Instrutor.txt");
        delFile3.createNewFile();



        int opcao;	// VARIÁVEIS LOCAL

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

        //novo.Pessoa p = new novo.Instrutor("a", "a"); // polimofismo de tipo uma super classe pode  instanciar uma sub class
        //novo.Instrutor i = new novo.Pessoa("a", "b");  // uma sub class não pode instanciar super class
        //objetos
        ControladorAluno controladorAluno = new ControladorAluno();
        ControladorInstrutor controladorInstrutor = new ControladorInstrutor();

        do {

            System.out.println("===================================================================");
            System.out.println("\t\tSEJA BEM-VINDO(A) AO SISTEMA DE CADASTRO:\n\n\t\t1 - novo.Aluno? Cadastre-se logo!\n\t\t2 - novo.Instrutor? Cadastre-se de imediato!\n\t\t3 - Pesquisar cadastro por CPF.\n\t\t4 - Listar cadastro(s).\n\t\t5 - Atualizar cadastro(s).\n\t\t6 - Deletar cadastro(s). \n\t\t7 - Sair do sistema.");
            System.out.print("===================================================================\n");
            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:

                    System.out.print("==================================================================\n");
                    System.out.println("--> Informe o nome do aluno: ");
                    nome = ler.nextLine();
                    gravarArq.printf(nome);

                    System.out.println("\n--> Informe o cpf: ");
                    cpf = ler.nextLine();
                    gravarArq.printf(cpf);

                    System.out.println("\n--> Informe a data de nascimento: ");
                    data_nascimento = ler.nextLine();
                    gravarArq.printf(data_nascimento);

                    System.out.println("\n--> Informe o bairro que reside: ");
                    bairro = ler.nextLine();
                    gravarArq.printf(bairro);

                    System.out.println("\n--> Informe o CEP: ");
                    cep = ler.nextLine();
                    gravarArq.printf(cep);

                    System.out.print("==================================================================\n");


                    endereco = new Endereco(bairro,cep);
                    aluno = new Aluno(nome, cpf); //excluido as outras variaveis
                    controladorAluno.cadastrarAluno(aluno);
                    System.out.println("\n");

                    arq.close();

                    break;
                case 2:

                    System.out.print("==================================================================\n");
                    System.out.println("--> Informe o nome do instrutor: ");
                    nome = ler.nextLine();
                    gravarArquivo.printf(nome);
                    System.out.println("\n--> Informe o cpf: ");
                    cpf = ler.nextLine();
                    gravarArquivo.printf(cpf);
                    System.out.println("\n--> Informe a data de nascimento: ");
                    data_nascimento = ler.nextLine();
                    gravarArquivo.printf(data_nascimento);
                    System.out.println("\n--> Informe o bairro que reside: ");
                    bairro = ler.nextLine();
                    gravarArquivo.printf(bairro);
                    System.out.println("\n--> Informe o CEP: ");
                    cep = ler.nextLine();
                    gravarArquivo.printf(cep);
                    System.out.println("\n--> Informe o cargo:");
                    cargo = ler.nextLine();
                    gravarArquivo.printf(cargo);
                    System.out.print("==================================================================\n");

                    endereco = new Endereco(bairro,cep);
                    instrutor = new Instrutor(nome, cpf, data_nascimento, cargo, endereco, cargo);
                    controladorInstrutor.cadastrarInstrutor(instrutor);

                    System.out.println("\n");

                    arquivo.close();

                    break;

                case 3:
                    System.out.println("\n\tQual cadastro você deseja buscar? \n");
                    System.out.println("\t\t1.Buscar Cadastro do novo.Aluno");
                    System.out.println("\t\t2.Buscar Cadastro do novo.Instrutor");

                    escolha = ler.nextInt();
                    ler.nextLine();

                    if(escolha == 2) {
                        System.out.println("--> Digite o CPF do novo.Instrutor desejado! \n" );
                        cpf = ler.nextLine();
                        controladorInstrutor.pesquisarInstrutor(cpf);
                        gravarArquivo.println(controladorInstrutor);


                    }if(escolha == 1) {
                    System.out.println("--> Digite o CPF do novo.Aluno desejado! \n" );
                    cpf = ler.nextLine();
                    //funçao
                    controladorAluno.pesquisarAluno(cpf);
                    gravarArq.printf(String.valueOf(controladorAluno));
                }
                    arquivo.close();
                    arq.close();
                    break;


                case 6:
                    System.out.println("\n\tQual Cadastro você deseja deletar? \n");
                    System.out.println("\t\t1.Deletar Cadastro novo.Aluno");
                    System.out.println("\t\t2.Deletar Cadastro novo.Instrutor");

                    escolha = ler.nextInt();
                    ler.nextLine();

                    if(escolha == 1) {
                        System.out.println("--> Digite o CPF do novo.Aluno que você deseja deletar!" );
                        cpf = ler.nextLine();
                        controladorAluno.deletarAluno(cpf);
                        gravarArq.printf(String.valueOf(controladorAluno));
                        delFile2.delete();


                    }if(escolha == 2) {
                    System.out.println("--> Digite o CPF do novo.Instrutor que você deseja deletar!" );
                    cpf = ler.nextLine();
                    delFile3.delete();


                    controladorInstrutor.deletarInstrutor(cpf);
                    gravarArquivo.printf(String.valueOf(controladorInstrutor));
                }
                    arq.close();
                    break;

                case 5:
                    System.out.println("\n\tQual Cadastro você deseja atualizar? \n");
                    System.out.println("\t\t1.Atualizar Cadastro novo.Aluno");
                    System.out.println("\t\t2.Atualizar Cadastro novo.Instrutor");

                    escolha = ler.nextInt();

                    if(escolha == 1) {
                        System.out.println("--> Digite o nome do novo.Aluno que você deseja atualizar!" );
                        antigoNome = ler.nextLine();
                        ler.nextLine();
                        gravarArq.printf(String.valueOf(ler));
                        System.out.println("--> Digite um  novo Nome!");
                        nome = ler.nextLine();
                        gravarArq.printf(nome);
                        System.out.println("--> Digite uma nova Data de Nascimento!");
                        data_nascimento = ler.nextLine();
                        gravarArq.printf(data_nascimento);
                        System.out.println("--> Digite um bairro:");
                        bairro = ler.nextLine();
                        gravarArq.printf(bairro);
                        System.out.println("--> Digite um novo cep:");
                        cep = ler.nextLine();
                        gravarArq.printf(cep);

                        endereco = new Endereco(bairro,cep);
                        controladorAluno.atualizarAluno(antigoNome, nome, data_nascimento, endereco);

                    }

                    if(escolha == 2) {
                        System.out.println("--> Digite o nome do novo.Instrutor que você deseja atualizar: " );
                        antigoNome = ler.nextLine();
                        ler.nextLine();
                        gravarArquivo.println(ler);

                        System.out.println("--> Digite um  novo nome: ");
                        nome = ler.nextLine();

                        gravarArquivo.println(nome);
                        System.out.println("--> Digite um  novo email: ");
                        data_nascimento = ler.nextLine();

                        gravarArquivo.println(data_nascimento);
                        System.out.println("--> Digite um novo bairro: ");
                        bairro = ler.nextLine();

                        gravarArquivo.println(bairro);
                        System.out.println("--> Digite um novo cep: ");
                        cep = ler.nextLine();

                        gravarArquivo.println(cep);
                        System.out.println("--> Digite novo cargo: ");
                        cargo = ler.nextLine();

                        gravarArquivo.println(cargo);

                        endereco = new Endereco(bairro,cep);
                        controladorInstrutor.atualizarInstrutor(antigoNome, nome, data_nascimento, endereco, cargo);
                        System.out.println("\n");
                    }
                    arquivo.close();
                    arq.close();
                    break;
                case 4:
                    System.out.println("\n\tQual Cadastro você deseja listar? \n");
                    System.out.println("\t\t1.Listar Cadastro novo.Aluno");
                    System.out.println("\t\t2.Listar Cadastro novo.Instrutor");

                    escolha = ler.nextInt();

                    if(escolha == 2) {

                        controladorInstrutor.listarInstrutor();
                        gravarArquivo.println(controladorInstrutor);

                    }if(escolha == 1) {

                    controladorAluno.listarAluno();
                    gravarArq.println(controladorAluno);
                }
                    arquivo.close();
                    arq.close();
                    break;

            }


        }
        while(opcao !=7);

    }



}
