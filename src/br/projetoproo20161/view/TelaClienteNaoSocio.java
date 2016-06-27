package br.projetoproo20161.view;

import br.projetoproo20161.bo.Cadastro;
import br.projetoproo20161.bo.ControllerClienteNaoSocio;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaClienteNaoSocio {
    
    Cadastro cad = new Cadastro();

    public void telaClienteNaoSocio() throws ClassNotFoundException, SQLException {
ControllerClienteNaoSocio cns = new ControllerClienteNaoSocio();
        String opc = "";

        do {
            opc = JOptionPane.showInputDialog("O que deseja fazer?\n"
                    + "1 - Verificar ingressos de jogos disponíveis\n"
                    + "2 - comprar jogos\n"
                    + "3 - Quero me tornar sócio e aproveitar os descontos e produtos exclusivos\n\n"
                    + "0 - Voltar ao menu principal\n"
            );

            if (opc.equals("1")) {

                cns.mostrandoPartidas();

            }else if (opc.equals("2")){
                cns.comprandoIngressoNaoSocio();
                
            }else if (opc.equals("3")){
                cad.Cadastrando();
            }

        } while (!opc.equals("0"));
    }

}
