/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.dao;

import br.projetoproo20161.dao.ConexaoMySQL;
import br.projetoproo20161.dao.IConexao;
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

/**
 *
 * @author Rochester
 */
public class ConexaoMySQLTeste extends TestCase{
    @Test
    public void testDeveriaConectarSeDadosCorretos() throws Exception {
		IConexao conexao = new ConexaoMySQL();
		assertNotNull(conexao.getConexao("jdbc:mysql","localhost","sociotorcedor","root",""));
	}
    @Test
public void testNaoDeveriaConectarSeUsuarioVazio() throws Exception {
		IConexao conexao = new ConexaoMySQL();
		assertNull(conexao.getConexao("jdbc:mysql","localhost","sociotorcedor","",""));
		
	}
}
