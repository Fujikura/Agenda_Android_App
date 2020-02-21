package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDAO {

    private static final List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;


    public void salvar(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    public void edita(Aluno aluno){
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);

        if(alunoEncontrado != null){
            int posicaoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoAluno, aluno);

        }
    }

    private Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a:alunos
             ) {
            if(a.getId() == aluno.getId()){

                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {
        Aluno alunoParaRemover = buscaAlunoPeloId(aluno);
        if(alunoParaRemover != null) {
            alunos.remove(alunoParaRemover);
        }
    }

    private void atualizaIds() {
        contadorDeIds++;
    }
}
