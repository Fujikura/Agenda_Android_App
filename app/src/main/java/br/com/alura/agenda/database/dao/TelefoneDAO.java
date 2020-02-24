package br.com.alura.agenda.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import br.com.alura.agenda.model.Telefone;

@Dao
public interface TelefoneDAO {

    @Query("SELECT t.* FROM Telefone AS t " +
            "JOIN Aluno AS a " +
            "ON t.alunoId = a.id " +
            "WHERE t.alunoId = :alunoId " +
            "LIMIT 1")
    Telefone buscarPrimeiroTelefoneDoAluno(int alunoId);
}
