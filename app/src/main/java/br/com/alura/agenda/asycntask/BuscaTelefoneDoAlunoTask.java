package br.com.alura.agenda.asycntask;

import android.os.AsyncTask;
import android.widget.TextView;

import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.model.Telefone;

public class BuscaTelefoneDoAlunoTask extends AsyncTask<Void, Void, Telefone> {
    private final TelefoneDAO dao;
    private final Aluno aluno;
    private TextView telefone;

    public BuscaTelefoneDoAlunoTask(TelefoneDAO dao, Aluno aluno, TextView telefone) {
        this.dao = dao;
        this.aluno = aluno;
        this.telefone = telefone;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {

        return dao.buscarPrimeiroTelefoneDoAluno(aluno.getId());
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefoneAluno) {
        super.onPostExecute(primeiroTelefoneAluno);
        if(primeiroTelefoneAluno != null)
            telefone.setText(primeiroTelefoneAluno.getNumero());
    }
}
