package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AlunoDAO alunoDAO = new AlunoDAO()                                                    ;
        alunoDAO.salvar(new Aluno("Alex", "88888888", "alex@alura.com.br"));
        alunoDAO.salvar(new Aluno("Fran", "99999999", "fran@alura.com.br"));
    }
}
