package br.projetoproo20161.dao;

import java.sql.Connection;

public class LoginDao {

Connection conexao;
	
	public LoginDao(Connection conexao) {
		this.conexao = conexao;
	}
}
