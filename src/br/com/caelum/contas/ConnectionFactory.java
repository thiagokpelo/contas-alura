package br.com.caelum.contas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public Connection getConnection() throws SQLException {
		System.out.println("conectando ...");

		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		
		return DriverManager.getConnection("jdbc:hsqldb:file:contas.db","sa", "");
	}

}
