package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Connector;

public class Promo extends Connector {

	private int valor_desconto;

	public Promo() throws SQLException {

	}

	public int getValor_desconto() {
		return valor_desconto;
	}

	public void setValor_desconto(int valor_desconto) {
		this.valor_desconto = valor_desconto;
	}

	public void cadastrarPromo(int desconto, int id_destino) throws SQLException {
		this.setValor_desconto(desconto);
		Promo promo = new Promo();
		String sql = "INSERT INTO " + this.tb_promo + "(valor_desconto, id_agencia, id_destinos) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = promo.connection.prepareStatement(sql)) {
			stmt.setInt(1, this.getValor_desconto());
			stmt.setInt(2, 1);
			stmt.setInt(3, id_destino);
			stmt.execute();
			stmt.close();
		}
		System.out.println("Promoção cadastrada com sucesso!");
	}

	public void consultarPromo() throws SQLException {
		Promo promo = new Promo();
		String sql = "SELECT * FROM " + this.tb_promo;
		try (Statement stmt = promo.connection.createStatement()) {
			stmt.executeQuery(sql);
			ResultSet result = stmt.getResultSet();
			while (result.next()) {
				System.out.println("id promo: "+result.getInt("id_promo") + " - Id Agência:  " + result.getInt("id_agencia") + " - Id Destinos: "
						+ result.getInt("id_destinos") + " - Valor desconto: " + result.getFloat("valor_desconto"));
			}
			stmt.close();
		}
	}

	public void updatePromo(int id, float valor) throws SQLException {
		Promo promo = new Promo();
		String sql = "UPDATE " + this.tb_promo + " SET valor_desconto = ? WHERE id_promo = ?";
		try (PreparedStatement stmt = promo.connection.prepareStatement(sql)) {
			stmt.setFloat(1,valor);
			stmt.setInt(2, id);
			stmt.execute();
			stmt.close();
			System.out.println("Update realizado com sucesso!");
		}
	}

	public void deletePromo(int id) throws SQLException {
		Promo promo = new Promo();
		String sql = "DELETE FROM " + this.tb_promo + "WHERE id =?";
		try (PreparedStatement stmt = promo.connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			System.out.println("Promo deletada!");
		}
	}

}
