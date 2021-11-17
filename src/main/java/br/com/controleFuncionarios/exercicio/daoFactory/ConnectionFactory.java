package br.com.controleFuncionarios.exercicio.daoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection connection;
	private static ConnectionFactory connectionFactory;

	private ConnectionFactory() {
		try {
		this.connection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=Funcionarios;user=kayque;password=Cintra@1998");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static synchronized ConnectionFactory conect() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
}

	
