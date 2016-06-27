package br.projetoproo20161.view;

import br.projetoproo20161.bo.Cadastro;
import br.projetoproo20161.bo.ControllerFuncionario;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class TelaFuncionario {

    public void telaFuncionario() throws SQLException, ClassNotFoundException, ParseException {
        String opc = "";

        Cadastro cadas = new Cadastro();
        ControllerFuncionario controlfun = new ControllerFuncionario();

        do {
            opc = JOptionPane.showInputDialog("O que deseja fazer?\n"
                    + "1 - Visualizar todos os clientes cadastrados\n"
                    + "2 - Cadastrar uma partida mais caravana\n"
                    + "3 - Visualizar relatório de ações dos clientes\n\n"
                    + "0 - Voltar para o menu principal.\n");

            if (opc.equals("1")) {

                cadas.monstrandoUsuario();

            } else if (opc.equals("2")) {

                controlfun.cadastrarIngresso();

            } else if (opc.equals("3")) {

            } else if (opc.equals("4")) {

            } else if (opc.equals("0")) {

            }

        } while (!opc.equals("0"));

    }

}
