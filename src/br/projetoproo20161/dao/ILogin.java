package br.projetoproo20161.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ILogin {
	
	
	 Connection getConexao(Integer cpf, String senha) throws
			SQLException;
			
		
	}
			


