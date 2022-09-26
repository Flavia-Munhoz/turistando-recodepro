package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Connector;

public class Agencia extends Connector {

	private int id;
	private String cnpj, nome, telefone, email;

	public Agencia() throws SQLException {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void cadastrarAgencia(String cnpj, String nome, String telefone, String email) throws SQLException {
		this.setCnpj(cnpj);
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
		Agencia turistando = new Agencia();
		String sql = "INSERT INTO " + this.tb_agencia + "(nome, cnpj, telefone, email) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = turistando.connection.prepareStatement(sql)) {
			stmt.setString(1, this.getNome());
			stmt.setString(2, this.getCnpj());
			stmt.setString(3, this.getTelefone());
			stmt.setString(4, this.getEmail());
			stmt.execute();
			stmt.close();
		}
		System.out.println("Agência cadastrada com sucesso!");
	}

	public void consultarAgencia() throws SQLException {
		Agencia turistando = new Agencia();
		String sql = "SELECT * FROM " + this.tb_agencia;
		try (Statement stmt = turistando.connection.createStatement()) {
			stmt.executeQuery(sql);
			ResultSet result = stmt.getResultSet();
			while (result.next()) {
				System.out.println(result.getInt("id_agencia") + " - " + result.getString("cnpj") + " - "
						+ result.getString("nome") + " - " + result.getString("telefone") + " - "
						+ result.getString("email"));

			}
			stmt.close();
		}
	}

	public String consultarAgencia2() throws SQLException {
		String string = "";
		Agencia turistando = new Agencia();
		String sql = "SELECT * FROM " + this.tb_agencia;
		try (Statement stmt = turistando.connection.createStatement()) {
			stmt.executeQuery(sql);
			ResultSet result = stmt.getResultSet();
			while (result.next()) {
				string = string + "CNPJ: " + result.getString("cnpj") + " - Nome: " + result.getString("nome")
						+ " - Telefone: " + result.getString("telefone") + " - E-mail: " + result.getString("email")
						+ "\n";

			}
			stmt.close();
			return string;
		}
	}

	public void updateAgencia(int id, String nome, String telefone, String email) throws SQLException {
		Agencia turistando = new Agencia();
		String sql = "UPDATE " + this.tb_agencia + " SET nome = ?, telefone = ?, email = ?  WHERE id_agencia = ?";
		try (PreparedStatement stmt = turistando.connection.prepareStatement(sql)) {
			stmt.setString(1, nome);
			stmt.setString(2, telefone);
			stmt.setString(3, email);
			stmt.setInt(4, id);
			stmt.execute();
			stmt.close();
			System.out.println("Update realizado com sucesso!");
		}
	}

	public void deletAgencia(int id) throws SQLException {
		Agencia turistando = new Agencia();
		String sql = "DELETE FROM " + this.tb_agencia + "WHERE id =?";
		try (PreparedStatement stmt = turistando.connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			System.out.println("Agencia deletada!");
		}
	}

}
