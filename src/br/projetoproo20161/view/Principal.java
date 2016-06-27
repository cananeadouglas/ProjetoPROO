package br.projetoproo20161.view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.projetoproo20161.dao.ConexaoMySQL;
import br.projetoproo20161.dao.IConexao;

public class Principal {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        IConexao banco = new ConexaoMySQL();
        banco.getConexao("jdbc:mysql", "localhost", "sociotorcedor", "root", "");
        TelaPrincipal t = new TelaPrincipal();

    }
}
