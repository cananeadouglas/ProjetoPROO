package br.projetoproo20161.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.projetoproo20161.*;
import br.projetoproo20161.bo.Cadastro;
import br.projetoproo20161.bo.Logando;

import java.util.Date;

import javax.swing.JOptionPane;

public class TelaPrincipal {

    public TelaPrincipal() throws SQLException, ClassNotFoundException {

        Cadastro cadastro = new Cadastro();
        Logando login = new Logando();
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");

        String opc = "";
        do {
            opc = JOptionPane.showInputDialog("Data Atual " + formatarDate.format(data) + "\n"
                    + "Bem Vindo  escolha a opção que deseja fazer\n"
                    + "1 - Gostaria de me cadastrar e virar sócio\n"
                    + "2 - Para logar\n"
                    + "3 - Não tenho cadastro e não desejo me cadastrar só desejo comprar\n\n"
                    + "0 - Para sair");
            if (opc.equals("1")) {

                cadastro.Cadastrando();

            } else if (opc.equals("2")) {
                login.Logando();

            } else if (opc.equals("3")) {
                TelaClienteNaoSocio t = new TelaClienteNaoSocio();
                t.telaClienteNaoSocio();

            } else if (opc.equals("0")) {
                JOptionPane.showMessageDialog(null, "Obrigado por usar nossos serviços");
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida,tente novamente");
            }

        } while (!opc.equals("0"));

    }

}
