package controle;

import java.util.ArrayList;

import novo.Endereco;
import novo.Instrutor;

public class ControladorInstrutor {


    private ArrayList<Instrutor> instrutores;

    public ControladorInstrutor() { //CONSTRUTOR
        instrutores = new ArrayList<>();
    }


    //MÉTODOS
    public void cadastrarInstrutor(Instrutor instrutor){
        instrutores.add(instrutor);
        System.out.println("\n\t\t" + instrutor.getNome() + "\n\t\tCadastrado(a) com sucesso!");
    }

    public void pesquisarInstrutor(String cpf) {

        for(int i = 0; i < instrutores.size(); i++ ) {
            if(instrutores.get(i).getCpf().equals(cpf)) {
                System.out.println("\t" + instrutores.get(i).getNome());
            }
        }
    }
    public void listarInstrutor(){
        System.out.println("\tLista de Instrutores cadastrados: ");
        if(instrutores.size() == 0) {
            System.out.println("\t<<<<Nenhum instrutor foi cadastrado>>>>");
        }else {
            for (Instrutor instrutor : instrutores) {
                System.out.println("\t" + instrutor.getNome());
            }
        }
    }

    public void atualizarInstrutor(String antigoNome,String novoNome, String data_nascimento,Endereco endereco,String cargo) {
        for(int i = 0; i < instrutores.size(); i++) {
            if(instrutores.get(i).getNome().equals(antigoNome)) {
                instrutores.get(i).setNome(novoNome);
                instrutores.get(i).setData_nascimento(data_nascimento);
                instrutores.get(i).setEndereco(endereco);
                instrutores.get(i).setCargo(cargo);
            }

        }


    }

    public void deletarInstrutor(String cpf) {
        for(int i = 0; i < instrutores.size(); i++ ) {
            if(instrutores.get(i).getCpf().equals(cpf)) {
                instrutores.remove(i);
                System.out.println("\tO instrutor foi removido");
            }else {
                System.out.println("\tInstrutor não encontrado");

            }
        }
    }

}