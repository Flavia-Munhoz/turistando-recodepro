package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Connector;

public class Promo extends Connector{
	
	private int valor_desconto;
	
	public Promo() throws SQLException{
		
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
		String sql = "INSERT INTO " + this.tb_promo
				+ "(valor_desconto, id_agencia, id_destinos) VALUES (?, ?, ?)";
		try(PreparedStatement stmt = promo.connection.prepareStatement(sql)){
			stmt.setInt(1, this.getValor_desconto());
			stmt.setInt(2, 1);
			stmt.setInt(3, id_destino);
			stmt.execute();
			stmt.close();
		}
		System.out.println("Promoção cadastrada com sucesso!");
	}
	
	
}
