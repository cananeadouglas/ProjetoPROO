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

    String diajogo = "";

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

    public void mostrarEventosempagemento() {
        String vetor = "";
        Integer idevento = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
            pstmt = con.prepareStatement("SELECT e.idevento, c.nome, e.valortotal FROM eventos e, cadastrandonosistema c WHERE c.idusuario = e.idusuario and e.pagamento = 'no' ");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {

                vetor += "Digite: " + result.getInt("idevento") + " para validar compra do Cliente: " + result.getString("nome") + " no valor Total de: R$ " + result.getDouble("valortotal") + ".\n";

            }

            idevento = Integer.parseInt(JOptionPane.showInputDialog(vetor + "\n\nPara dizer que o usuário efetuou o pagamento e liberando-o para\n"
                    + "assistir aos jogos, você administrador tem q informar uma opção acima\n ou 0 para sair"));

            if (idevento == 0) {

            } else {

                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
                pstmt = conexao.prepareStatement("UPDATE eventos SET pagamento= 'sim' WHERE idevento = '" + idevento + "' ");

                int i = pstmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Marcação efetuada com sucesso");

                } else {
                    JOptionPane.showMessageDialog(null, "Marcação não efetuada");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void mostrarEventosPagamentoEfetivado() {

        String vetor = "";
        Integer idevento = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");
            pstmt = con.prepareStatement("SELECT e.idevento, c.nome, e.valortotal FROM eventos e, cadastrandonosistema c, partidas p WHERE c.idusuario = e.idusuario and e.pagamento = 'sim' and p.diajogo >= CURRENT_DATE ");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {

                vetor += "Cliente: " + result.getString("nome") + " no valor Total de: R$ " + result.getDouble("valortotal") + ". Pagamento OK\n";

            }

            JOptionPane.showMessageDialog(null, vetor);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void saldodoDia() {

        Double valor = 0.0;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///sociotorcedor", "root", "");

            pstmt = con.prepareStatement("SELECT SUM(valortotal) FROM eventos WHERE pagamento = 'sim' ");
            ResultSet result3 = pstmt.executeQuery();
            while (result3.next()) {
                valor = result3.getDouble(1);
            }

            JOptionPane.showMessageDialog(null, "Saldo do Dia: R$" + valor + "0.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

}
