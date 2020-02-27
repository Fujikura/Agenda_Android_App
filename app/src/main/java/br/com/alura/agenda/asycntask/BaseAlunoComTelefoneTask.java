package br.com.alura.agenda.asycntask;

import android.os.AsyncTask;

import br.com.alura.agenda.model.Telefone;

public abstract class BaseAlunoComTelefoneTask extends AsyncTask<Void, Void, Void> {

    private final FinalizadaListener listener;

    public BaseAlunoComTelefoneTask(FinalizadaListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.quandoFinalizada();
    }

    protected void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone : telefones) {
            telefone.setAlunoId(alunoId);
        }
    }

    public interface FinalizadaListener{
        void quandoFinalizada();
    }
}
