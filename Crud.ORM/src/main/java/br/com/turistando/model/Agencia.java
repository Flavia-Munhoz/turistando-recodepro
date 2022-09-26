package br.com.turistando.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_agencia;
	private String cnpj;
	private String nome;
	private String telefone;
	private String email;
	
	public Agencia() {
		
	}

	public Agencia(Integer id_agencia, String cnpj, String nome, String telefone, String email) {
		super();
		this.id_agencia = id_agencia;
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Agencia(String cnpj, String nome, String telefone, String email) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getId_agencia() {
		return id_agencia;
	}

	public void setId_agencia(Integer id_agencia) {
		this.id_agencia = id_agencia;
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

	@Override
	public String toString() {
		return "Agencia [id_agencia=" + id_agencia + ", cnpj=" + cnpj + ", nome=" + nome + ", telefone=" + telefone
				+ ", email=" + email + "]";
	}
	
	
	
}
