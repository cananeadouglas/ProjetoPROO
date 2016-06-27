package br.projetoproo20161.bo;

import br.projetoproo20161.dao.IConexao;
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

    IConexao banco;
    Connection conexao;
    Connection con = null;
    PreparedStatement pstmt = null;

    public void mostrandoPartidas() throws SQLException, ClassNotFoundException {

        String vetor="";
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
            pstmt = con.prepareStatement("SELECT idjogos,jogos,diajogo,valorjogo,caravana FROM partidas WHERE diajogo >= CURRENT_DATE");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {

                vetor += "Digite: " + result.getInt("idjogos") + " para jogo: " + result.getString("jogos") + ", no Dia: " + result.getDate("diajogo") + ", Valor do Jogo: R$ " + result.getDouble("valorjogo") + ", Valor da caravana: R$ " + result.getDouble("caravana") + ";\n";

            }
            vetor += "\nTodos os jogos que estão disponíveis ";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        JOptionPane.showMessageDialog(null, vetor);

    }

    /**
     *
     * @throws SQLException
     */
    @Override
    public void comprarIngresso() throws SQLException {

        String opc = "", vetor = "";
        Integer cpf = null, idusuario = null, idjogos = null;
        Double valorjogo = 0.0;
        String senha = "";

        opc = JOptionPane.showInputDialog("Digite 1 para comprar jogo\n"
                + "Digite 2 para comprar jogo com a caravana \n\n"
                + "Ou digite 0 para voltar para o menu\n"
                + "\n VOCÊ CLIENTE SÓCIO TEM DESCONTO DE 15%");

        if (opc.equals("1")) {

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
                cpf = Integer.parseInt(JOptionPane.showInputDialog("digite seu cpf para confirmação dos dados"));
                senha = JOptionPane.showInputDialog("agora a sua senha");
                //// resgatando o id do usuário
                pstmt = con.prepareStatement("SELECT idusuario FROM cadastrandonosistema WHERE cpf = '" + cpf + "' and senha = '" + senha + "' ");
                ResultSet result2 = pstmt.executeQuery();
                while (result2.next()) {
                    idusuario = result2.getInt("idusuario");
                }
                //// resgatando valor jogo
                pstmt = con.prepareStatement("SELECT valorjogo FROM partidas WHERE idjogos = '" + idjogos + "' ");
                ResultSet result3 = pstmt.executeQuery();
                while (result3.next()) {
                    valorjogo = result3.getDouble("valorjogo");
                }
                valorjogo = valorjogo * 0.85;
                JOptionPane.showMessageDialog(null, "Vocẽ irá pagar o valor de " + valorjogo);

                //// inserindo em eventos
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
                pstmt = conexao.prepareStatement("INSERT INTO eventos (idusuario, idjogos, valortotal, pagamento) VALUES ('" + idusuario + "','" + idjogos + "','" + valorjogo + "', 'no')  ");

                int i = pstmt.executeUpdate();
                if (i > 0) {
                    
                    JOptionPane.showMessageDialog(null, "solicitação bem sucedida");

                } else {
                    JOptionPane.showMessageDialog(null, "solicitação mal sucedida");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            opc = "";
            vetor = "";
            cpf = null;
            idusuario = null;
            idjogos = null;
            valorjogo = 0.0;
            senha = "";

        } else if (opc.equals("2")) {

            Double caravana = 0.0;
            Double valortotal = 0.0;

            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
                pstmt = con.prepareStatement("SELECT idjogos,jogos,diajogo,valorjogo,caravana FROM partidas WHERE diajogo >= CURRENT_DATE");

                ResultSet result = pstmt.executeQuery();

                while (result.next()) {

                    vetor += "Digite: " + result.getInt("idjogos") + " para comprar o Jogo: " + result.getString("jogos") + ", Data: " + result.getDate("diajogo") + ", no Valor de: R$ " + result.getDouble("valorjogo") + "; e a caravana é R$ " + result.getDouble("caravana") + "\n";

                }
                vetor += "\nTodos os jogos que estão disponíveis ";

                idjogos = Integer.parseInt(JOptionPane.showInputDialog(vetor));
                cpf = Integer.parseInt(JOptionPane.showInputDialog("digite seu cpf para confirmação dos dados"));
                senha = JOptionPane.showInputDialog("agora a sua senha");
                //// resgatando o id do usuário
                pstmt = con.prepareStatement("SELECT idusuario FROM cadastrandonosistema WHERE cpf = '" + cpf + "' and senha = '" + senha + "' ");
                ResultSet result2 = pstmt.executeQuery();
                while (result2.next()) {
                    idusuario = result2.getInt("idusuario");
                }
                //// resgatando valor jogo
                pstmt = con.prepareStatement("SELECT valorjogo,caravana FROM partidas WHERE idjogos = '" + idjogos + "' ");
                ResultSet result3 = pstmt.executeQuery();
                while (result3.next()) {
                    valorjogo = result3.getDouble("valorjogo");
                    caravana = result3.getDouble("caravana");
                }
                valortotal = valorjogo + caravana;
                valortotal = valortotal * 0.85;
                JOptionPane.showMessageDialog(null, "Vocẽ irá pagar o valor de " + valortotal + "\njogo + caravana");

                //// inserindo em eventos
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
                pstmt = conexao.prepareStatement("INSERT INTO eventos (idusuario, idjogos, valortotal, pagamento) VALUES ('" + idusuario + "','" + idjogos + "','" + valortotal + "', 'no')  ");

                int i = pstmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "solicitação bem sucedida");

                } else {
                    JOptionPane.showMessageDialog(null, "solicitação mal sucedida");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            caravana = 0.0;
            valortotal = 0.0;

        } else {
            JOptionPane.showMessageDialog(null, "digite uma opção válica");
        }

    }

}
