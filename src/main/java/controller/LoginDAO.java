package controller;

import java.sql.*;

import model.*;

public class LoginDAO {
	
	public static Connection getConn() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ivonete Tecla Gomes\\eclipse-workspace\\Sistema De Vendas\\src\\main\\java\\dataBase\\loginDB.db");
		return connection;
	}
	
	
	public void cadastrarUsuario(Usuario us) throws SQLException {
		Statement sts = getConn().createStatement();
		sts.execute("CREATE TABLE IF NOT EXISTS usuario(id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, nome VARCHAR(45) NULL, telefone VARCHAR(45) NULL, cidade VARCHAR(45) NULL, email VARCHAR(45) NULL, senha VARCHAR(13) NULL)");
		try {
			Connection conn = getConn();
			PreparedStatement pre = conn.prepareStatement("INSERT INTO usuario VALUES (null, ?, ?, ?, ?, ?)");
			pre.setString(1, us.getNome());
			pre.setString(2, us.getTelefone());
			pre.setString(3, us.getCidade());
			pre.setString(4, us.getEmail());
			pre.setString(5, us.getSenha());
			pre.execute();
			System.out.println("Usuario salvo: " + us.getNome());
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean verificarLogin(Login login) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
		try (
			Connection conn = getConn();
			PreparedStatement pre = conn.prepareStatement(sql)
			){
				pre.setString(1, login.getNome());
				pre.setString(2, login.getSenha());
				try (ResultSet rs = pre.executeQuery()){
					return rs.next();
				}
			}
	}
}
