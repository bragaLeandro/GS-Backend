package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoSingleton {

	private static ConexaoSingleton instance;
	private Connection conn = null;
	
	private ConexaoSingleton() {
		try {
			abrirConexao();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static ConexaoSingleton getInstance() {
		try {
			if (instance == null) {
				instance = new ConexaoSingleton();
			}
			return instance;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Connection abrirConexao() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

			conn = DriverManager.getConnection(url, Dados.USER, Dados.PASSWORD);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public void fecharConexao() {
		try {
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
