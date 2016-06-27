package br.projetoproo20161.bo;

import br.projetoproo20161.modelo.Cliente;
import br.projetoproo20161.modelo.Cliente_socio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlerClienteSocio extends Cliente_socio {
	
            Connection con = null;
	 PreparedStatement pstmt = null;
         
         public void mostrandoPartidas() throws SQLException, ClassNotFoundException {
	
	  String vetor = "";
      
      try {
          
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
          pstmt = con.prepareStatement("SELECT idjogos,jogos,diajogo,valorjogo,caravana FROM partidas");

          ResultSet result = pstmt.executeQuery();

          ArrayList<String> array = new ArrayList<String>();
          
          while (result.next()) {

              vetor += "Opção: " + result.getString("idjogos")+" Jogo: " + result.getString("jogos") + ", Data: " + result.getString("diajogo") +", Valor do Jogo: "+result.getString("valorjogo")+", Valor da caravana:"+result.getString("caravana")+";\n";

          }
          vetor += "\nTodos os jogos que estão disponíveis ";

      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
      }

          JOptionPane.showMessageDialog(null, vetor);

}

        public void comprarIngresso () throws SQLException{
    String vetor = "";
    String vetor2 = "";
    String id = "";
   
      
      try {
          
          
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
          pstmt = con.prepareStatement("SELECT idjogos,jogos,diajogo,valorjogo,caravana FROM partidas");

          ResultSet result = pstmt.executeQuery();

          ArrayList<String> array = new ArrayList<String>();
          
          while (result.next()) {

              vetor += "Opção: " + result.getString("idjogos")+" Jogo: " + result.getString("jogos") + ", Data: " + result.getString("diajogo") +", Valor do Jogo: "+result.getString("valorjogo")+", Valor da caravana:"+result.getString("caravana")+";\n";

          }
          vetor += "\nTodos os jogos que estão disponíveis ";

      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
      }

          String opc = JOptionPane.showInputDialog("Escolha a opção para qual ingresso de jogo deseja comprar\n"+vetor);
          pstmt = con.prepareStatement("SELECT idjogos,valorjogo FROM partidas WHERE idjogos ='"+opc+"'");
          ResultSet result = pstmt.executeQuery();
           while (result.next()){
          vetor2 += ""+result.getString("valorjogo")+""+result.getString("idjogos");
           id = result.getString("idjogos");
           
           if (vetor.length() > 1){
               
                     if (opc.equals(id)) {
                
                JOptionPane.showMessageDialog(null, "valor a ser pago ");
                     }
               } else
                   
                   JOptionPane.showMessageDialog(null, "Opção inválida");
               
         
           
          
           }
    }
	
void comprarIngressoCaravana (Integer qtd){
    	
    }

}
