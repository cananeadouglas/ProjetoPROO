package br.projetoproo20161.view;

import br.projetoproo20161.bo.ControllerClienteNaoSocio;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaClienteNaoSocio {

    public void telaClienteNaoSocio() throws ClassNotFoundException, SQLException {

        String opc = "";

        do {
            opc = JOptionPane.showInputDialog("O que deseja fazer?\n"
                    + "1 - Verificar ingressos de jogos disponíveis\n"
                    + "2 - Quero me tornar sócio e aproveitar os descontos e produtos exclusivos\n"
                    + "3 - Voltar ao menu principal\n"
            );

            if (opc.equals("1")) {

                ControllerClienteNaoSocio cns = new ControllerClienteNaoSocio();
                cns.mostrandoPartidas();

            }

        } while (!opc.equals("3"));
    }

}
