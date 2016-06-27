package br.projetoproo20161.bo;

import br.projetoproo20161.dao.IConexao;
import br.projetoproo20161.modelo.Cliente;
import br.projetoproo20161.modelo.Cliente_nao_socio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControllerClienteNaoSocio extends Cliente_nao_socio{

     IConexao banco;
    Connection conexao;
     Connection con = null;
	 PreparedStatement pstmt = null;

	public void mostrandoPartidas() throws SQLException, ClassNotFoundException {
		
		  String vetor = "";
	      
	      try {
	          
	          Class.forName("com.mysql.jdbc.Driver");
	          con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
	          pstmt = con.prepareStatement("SELECT idjogos,jogos,diajogo,valorjogo,caravana FROM partidas WHERE diajogo >= CURRENT_DATE");

	          ResultSet result = pstmt.executeQuery();
                         
	          while (result.next()) {

	              vetor += "Opção: " + result.getString("idjogos")+" Jogo: " + result.getString("jogos") + ", Data: " + result.getString("diajogo") +", Valor do Jogo: "+result.getString("valorjogo")+", Valor da caravana:"+result.getString("caravana")+";\n";

	          }
	          vetor += "\nTodos os jogos que estão disponíveis ";
                  
                  JOptionPane.showMessageDialog(null, vetor);

	      } catch (Exception e) {
	          JOptionPane.showMessageDialog(null, e.getMessage());
	      }

	}	
	
        
        public void comprandoIngressoNaoSocio(){
            
        String opc = "", vetor = "";
        Integer cpf = null, idusuario = null, idjogos = null;
        Double valorjogo = 0.0;
        String senha = "";

            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
                pstmt = con.prepareStatement("SELECT idjogos,jogos,diajogo,valorjogo FROM partidas WHERE diajogo >= CURRENT_DATE");

                ResultSet result = pstmt.executeQuery();

                while (result.next()) {

                    vetor += "Digite: " + result.getInt("idjogos") + " para comprar o Jogo: " + result.getString("jogos") + ", Data: " + result.getDate("diajogo") + ", no Valor de: R$ " + result.getDouble("valorjogo") + ";\n";

                }
                vetor += "\nTodos os jogos que estão disponíveis ";

                idjogos = Integer.parseInt(JOptionPane.showInputDialog(vetor));
                              
                //// resgatando valor jogo
                pstmt = con.prepareStatement("SELECT valorjogo FROM partidas WHERE idjogos = '" + idjogos + "' ");
                ResultSet result3 = pstmt.executeQuery();
                while (result3.next()) {
                    valorjogo = result3.getDouble("valorjogo");
                }
                JOptionPane.showMessageDialog(null, "Você irá pagar: " +valorjogo+ "0.");

                //// inserindo em eventos
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
                pstmt = conexao.prepareStatement("INSERT INTO eventos (idusuario, idjogos, valortotal, pagamento) VALUES (6,'" + idjogos + "','" + valorjogo + "', 'no')  ");

                int i = pstmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "solicitação bem sucedida");

                } else {
                    JOptionPane.showMessageDialog(null, "solicitação mal sucedida");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

       
            
        }

	
}
