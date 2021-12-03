package controle;

import java.util.ArrayList;
import novo.Aluno;
import novo.Endereco;


public class ControladorAluno {
    //tipo de dados para listas
    private ArrayList<Aluno> alunos;

    public ControladorAluno() {
        alunos = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno){
        alunos.add(aluno);
        System.out.println("\n\t\t" + aluno.getNome() + "\n\t\tCadastrado(a) com sucesso!");

    }

    public void pesquisarAluno(String cpf) {

        for(int i = 0; i < alunos.size(); i++ ) {
            if(alunos.get(i).getCpf().equals(cpf)) {
                System.out.println(alunos.get(i).getNome() + " numero da matrícula: " + alunos.get(i).getNumMatricula());
            }
        }

    }

    public void listarAluno(){
        System.out.println("\tLista de Alunos cadastrados: ");
        if(alunos.size() == 0) {
            System.out.println("\t<<<<Nenhum aluno foi cadastrado.>>>>");
        }else {
            for (Aluno aluno : alunos) {
                System.out.println("\t" + aluno.getNome());
            }

        }
    }


    public void atualizarAluno(String antigoNome,String novoNome, String data_nascimento,Endereco endereco) {
        for(int i = 0; i < alunos.size(); i++) {
            if(alunos.get(i).getNome().equals(antigoNome)) {
                alunos.get(i).setNome(novoNome);
                alunos.get(i).setData_nascimento(data_nascimento);
                alunos.get(i).setEndereco(endereco);
            }

        }

    }

    public void deletarAluno(String cpf) {
        for(int i = 0; i < alunos.size(); i++ ) {
            if(alunos.get(i).getCpf().equals(cpf)) {
                alunos.remove(i);
                System.out.println("\tO Aluno foi removido");
            }else {
                System.out.println("\tAluno não encontrado");
            }
        }

    }


}
