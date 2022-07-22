package controller;

import java.sql.*;

import model.Produto;

public class ProdutoDAO {
	public static Connection getConn() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:sqlite:src\\main\\java\\dataBase\\loginDB.db");
		return connection;
	}
	public void cadastrarProduto(Produto prod) throws SQLException {
		Statement sts = getConn().createStatement();
		sts.execute("CREATE TABLE IF NOT EXISTS produto(id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, nome VARCHAR(45) NULL, quantidade INTEGER NULL, valor_unitario INTEGER NULL)");
		try {
			Connection con = getConn();
			PreparedStatement pr = con.prepareStatement("INSERT INTO produto VALUES(null, ?, ?, ?)");
			pr.setString(1, prod.getNome());
			pr.setInt(2, prod.getQuant());
			pr.setInt(3, prod.getValorUnitario());
			pr.execute();
			System.out.println("Produto salvo com nome " + prod.getNome());
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
