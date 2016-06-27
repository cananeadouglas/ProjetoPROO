package br.projetoproo20161.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.projetoproo20161.dao.IConexao;
import br.projetoproo20161.dao.ILogin;
import br.projetoproo20161.view.TelaCliente;
import br.projetoproo20161.view.TelaFuncionario;

public class Logando implements ILogin {
    
    	Integer cpf;
	String pass;
        String vetor = " ";
        
	IConexao banco;
	Connection conexao;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
        
	public void Logando() throws ClassCastException,SQLException {
		
		String type = "";
		
		try {
			cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite seu cpf"));
			pass = JOptionPane.showInputDialog("Digite sua senha");
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
			pstmt = conexao.prepareStatement("SELECT cpf,senha,tipo FROM cadastrandonosistema WHERE cpf = '"+cpf+"' and senha = '"+pass+"' ");
			ResultSet result = pstmt.executeQuery();
			
                        ArrayList<String> array = new ArrayList<String>();
			while (result.next()) {
				vetor += "cpf:" + result.getString("cpf") + result.getString("senha") + "\n";
                                type += result.getString("tipo");
			}
                        
                        
			if (vetor.length() > 1) {
                            
                  ///////////////////////////////////////////////// verificando se o usuário é adm
                        
                                if (type.equals("adm")) { 
                                    
                                    JOptionPane.showMessageDialog(null, "Logado como Funcionario Administrador");
                                    TelaFuncionario telafun = new TelaFuncionario();
                                    telafun.telaFuncionario();
                                    
                                }else if (type.equals("cliente")){
                                    
                                    JOptionPane.showMessageDialog(null, "Logado como Sócio Cliente");
                                    TelaCliente T = new TelaCliente();
                                    T.TelaPrincipalCliente();
                                    
                                }
                                	
			}
			else {
				
				JOptionPane.showMessageDialog(null, "Usuário ou senha não confere");
			}
				vetor = " ";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} finally {
			pstmt.close();
		}
			
	}

	@Override
	public Connection getConexao(Integer cpf, String senha) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
        
      

}
