package br.com.alura.agenda.asycntask;

import android.os.AsyncTask;

import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.model.Telefone;

public class BuscaTelefoneDoAlunoTask extends AsyncTask<Void, Void, Telefone> {
    private final TelefoneDAO dao;
    private final Aluno aluno;
    private final PrimeiroTelefoneEncontradoListener listener;

    public BuscaTelefoneDoAlunoTask(TelefoneDAO dao, Aluno aluno, PrimeiroTelefoneEncontradoListener listener) {
        this.dao = dao;
        this.aluno = aluno;
        this.listener = listener;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {

        return dao.buscarPrimeiroTelefoneDoAluno(aluno.getId());
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefoneAluno) {
        super.onPostExecute(primeiroTelefoneAluno);
        listener.quandoEncontrado(primeiroTelefoneAluno);
    }

    public interface PrimeiroTelefoneEncontradoListener {
        void quandoEncontrado(Telefone telefoneEncontrado);
    }
}
