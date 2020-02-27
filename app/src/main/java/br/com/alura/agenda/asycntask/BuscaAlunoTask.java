package br.com.alura.agenda.asycntask;

import android.os.AsyncTask;

import br.com.alura.agenda.database.dao.AlunoDAO;
import br.com.alura.agenda.ui.adapter.ListaAlunosAdapter;

public class BuscaAlunoTask extends AsyncTask {

    private final ListaAlunosAdapter adapter;
    private final AlunoDAO dao;

    public BuscaAlunoTask(ListaAlunosAdapter adapter, AlunoDAO dao) {
        this.adapter = adapter;
        this.dao = dao;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        adapter.atualiza(dao.todos());
        return null;
    }
}
