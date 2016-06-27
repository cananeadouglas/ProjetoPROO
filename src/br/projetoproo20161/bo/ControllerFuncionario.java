package br.projetoproo20161.bo;

import br.projetoproo20161.modelo.Funcionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import br.projetoproo20161.dao.CadastroDao;
import br.projetoproo20161.dao.ConexaoMySQL;
import br.projetoproo20161.dao.IConexao;
import br.projetoproo20161.view.TelaCliente;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date; 


public class ControllerFuncionario extends Funcionario {

    IConexao banco;
    Connection conexao;

    Connection con = null;
    PreparedStatement pstmt = null;
    
            String diajogo ="";

    public void cadastrarIngresso() throws ParseException {

        String jogos = JOptionPane.showInputDialog("Digite o jogo para cadastro Ex. (CSA x CRB)");
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dataStr = JOptionPane.showInputDialog("digite o dia do jogo citado anteriormente");
        java.sql.Date diajogo = new java.sql.Date(format.parse(dataStr).getTime());
        
        Double valorjogo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da Entrada por Pessoa"));
        Double caravana = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da caravana ou viagem por Pessoa"));

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
            pstmt = conexao.prepareStatement("INSERT INTO partidas (jogos, diajogo, valorjogo, caravana) VALUES (?,?,?,?) ");

            pstmt.setString(1, jogos);
            pstmt.setDate(2, diajogo);
            pstmt.setDouble(3, valorjogo);
            pstmt.setDouble(4, caravana);
            
            int i = pstmt.executeUpdate();
            
	            if (i > 0) {
	                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
                                                
	            } else {
	                JOptionPane.showMessageDialog(null, "nenhum dado inserido");
	            }

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }

    }

    public void cadastrarIngressoMaisCaravana() {
        

    }
}
