package br.com.alura.agenda.asycntask;

import br.com.alura.agenda.database.dao.AlunoDAO;
import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.model.Telefone;

public class SalvaAlunoTask extends BaseAlunoComTelefoneTask {
    private final Aluno aluno;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final AlunoDAO alunoDAO;
    private final TelefoneDAO telefoneDAO;

    public SalvaAlunoTask(
            Aluno aluno,
            Telefone telefoneFixo,
            Telefone telefoneCelular,
            AlunoDAO alunoDAO,
            TelefoneDAO telefoneDAO,
            FinalizadaListener listener) {
        super(listener);
        this.aluno = aluno;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.alunoDAO = alunoDAO;
        this.telefoneDAO = telefoneDAO;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        int alunoId = alunoDAO.salvar(aluno).intValue();
        vinculaAlunoComTelefone(alunoId, telefoneFixo, telefoneCelular);
        telefoneDAO.salvar(telefoneFixo, telefoneCelular);
        return null;
    }

}
