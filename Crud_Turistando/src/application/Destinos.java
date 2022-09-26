package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Connector;

public class Destinos extends Connector {
	private int id, idAgencia;
	private String pais, estado, cidade;
	private float valor;

	public Destinos() throws SQLException {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	public void cadastrarDestino(String pais, String estado, String cidade, float valor) throws SQLException {
		this.setIdAgencia(1);
		this.setPais(pais);
		this.setEstado(estado);
		this.setCidade(cidade);
		this.setValor(valor);
		Destinos destino = new Destinos();
		String sql = "INSERT INTO " + this.tb_destinos
				+ "(pais, estado, cidade, valor, id_agencia) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = destino.connection.prepareStatement(sql)) {
			stmt.setString(1, this.getPais());
			stmt.setString(2, this.getEstado());
			stmt.setString(3, this.getCidade());
			stmt.setFloat(4, this.getValor());
			stmt.setInt(5, this.getIdAgencia());
			stmt.execute();
			stmt.close();
		}
		System.out.println("Destino cadastrado com sucesso!");
	}

	public void consultarDestinos() throws SQLException {
		Destinos destino = new Destinos();
		String sql = "SELECT id_destinos, pais, estado, cidade, valor FROM " + this.tb_destinos;
		try (Statement stmt = destino.connection.createStatement()) {
			stmt.executeQuery(sql);
			ResultSet result = stmt.getResultSet();
			while (result.next()) {
				System.out.println(result.getInt("id_destinos") + " - " + result.getString("pais") + " - "
						+ result.getString("estado") + " - " + result.getString("cidade") + " - "
						+ result.getFloat("valor"));

			}
			stmt.close();
		}
	}

	public String consultarDestinos2() throws SQLException {
		String string = "";
		Destinos destino = new Destinos();
		String sql = "SELECT id_destinos, pais, estado, cidade, valor FROM " + this.tb_destinos;
		try (Statement stmt = destino.connection.createStatement()) {
			stmt.executeQuery(sql);
			ResultSet result = stmt.getResultSet();
			while (result.next()) {
				string = string + "Pais: " + result.getString("pais") + " - Estado: " + result.getString("estado")
						+ " - Cidade: " + result.getString("cidade") + "\n";

			}
			stmt.close();
		}
		return string;
	}

	public void updateDestino(int id, String cidade, String estado, String pais, float valor) throws SQLException {
		Destinos destino = new Destinos();
		String sql = "UPDATE " + this.tb_destinos + " SET cidade = ?, estado = ?, pais = ?, valor = ? WHERE id_destinos = ?";
		try (PreparedStatement stmt = destino.connection.prepareStatement(sql)) {
			stmt.setString(1, cidade);
			stmt.setString(2, estado);
			stmt.setString(3, pais);
			stmt.setFloat(4, valor);
			stmt.setInt(5, id);
			stmt.execute();
			stmt.close();
			System.out.println("Update realizado com sucesso!");
		}
	}

	public void deletDestino(int id) throws SQLException {
		Destinos destino = new Destinos();
		String sql = "DELETE FROM " + this.tb_destinos + "WHERE id =?";
		try (PreparedStatement stmt = destino.connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			System.out.println("Destino deletado!");
		}
	}
}
