package br.projetoproo20161.view;

import br.projetoproo20161.bo.ControlerClienteSocio;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import br.projetoproo20161.bo.ControlerClienteSocio;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaCliente {

    public void TelaPrincipalCliente() throws ClassNotFoundException, SQLException {

        String opc = "";
        String opc2 = "";
        do {
            opc = JOptionPane.showInputDialog("O que gostaria de fazer?\n"
                    + "1 - Verificar os Ingressos dos jogos disponíveis\n"
                    + "2 - Comprar ingressos com ou sem caravana COM DESCONTO PARA SÓCIOS\n\n"
                    + "0 - Sair deste menu e voltar para o principal ?");

            if (opc.equals("1")) {

                ControlerClienteSocio cs = new ControlerClienteSocio();
                cs.mostrandoPartidas();
            }
             if (opc.equals("2")) {
                 ControlerClienteSocio cs = new ControlerClienteSocio();
                 cs.comprarIngresso();
                }

        } while (!opc.equals("0"));

    }
    
}