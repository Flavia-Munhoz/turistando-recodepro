package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.Connector;

public class Agencia extends Connector {

	private int id;
	private String cnpj, nome, telefone, email;
	
	public Agencia() throws SQLException{
		
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
		String sql = "INSERT INTO " + this.tb_agencia
				+ "(nome, cnpj, telefone, email) VALUES (?, ?, ?, ?)";
		try(PreparedStatement stmt = turistando.connection.prepareStatement(sql)){
			stmt.setString(1, this.getNome());
			stmt.setString(2, this.getCnpj());
			stmt.setString(3, this.getTelefone());
			stmt.setString(4, this.getEmail());
			stmt.execute();
			stmt.close();
		}
		System.out.println("Agência cadastrada com sucesso!");
	}
	
	
	
}