package br.com.alura.agenda.asycntask;

import android.os.AsyncTask;

import br.com.alura.agenda.database.dao.AlunoDAO;
import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.model.Telefone;

public class SalvaAlunoTask extends AsyncTask<Void, Void, Void> {
    private final Aluno aluno;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final AlunoDAO alunoDAO;
    private final TelefoneDAO telefoneDAO;
    private final QuandoAlunoSalvoListener listener;

    public SalvaAlunoTask(Aluno aluno, Telefone telefoneFixo, Telefone telefoneCelular, AlunoDAO alunoDAO, TelefoneDAO telefoneDAO, QuandoAlunoSalvoListener listener) {
        this.aluno = aluno;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.alunoDAO = alunoDAO;
        this.telefoneDAO = telefoneDAO;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        int alunoId = alunoDAO.salvar(aluno).intValue();
        vinculaAlunoComTelefone(alunoId, telefoneFixo, telefoneCelular);
        telefoneDAO.salvar(telefoneFixo, telefoneCelular);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.quandoSalvo();
    }

    private void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone : telefones) {
            telefone.setAlunoId(alunoId);
        }
    }


    public interface QuandoAlunoSalvoListener{
        void quandoSalvo();
    }

}
