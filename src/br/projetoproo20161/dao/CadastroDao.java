package br.projetoproo20161.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CadastroDao {

    Connection conexao;

    public CadastroDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(String nome, Integer idade, Integer cpf, Integer telefone, String email, String sexo, String senha) throws SQLException {
        Statement stmt = null;

        try {
            stmt = this.conexao.createStatement();
            stmt.executeUpdate("insert into cadastrandonosistema(nome,idade,cpf,telefone,email,sexo,senha) values('" + nome + "','" + idade + "','" + cpf + "','" + telefone + "','" + email + "','" + sexo + "','" + senha + "')");
            System.out.println("Cadastrado efetuado!");
        } catch (SQLException e) {
            throw new SQLException("Erro: " + e.getMessage());
        }
    }

}
