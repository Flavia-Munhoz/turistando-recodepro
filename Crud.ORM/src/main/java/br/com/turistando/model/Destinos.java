package br.com.turistando.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Destinos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_destino;
	private Integer id_agencia;
	private String pais;
	private String estado;
	private String cidade;
	private Float valor;
	
	public Destinos() {
		
	}

	public Destinos(Integer id_destino, Integer id_agencia, String pais, String estado, String cidade, float valor) {
		super();
		this.id_destino = id_destino;
		this.id_agencia = id_agencia;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.valor = valor;
	}
	
	public Destinos(Integer id_agencia, String pais, String estado, String cidade, float valor) {
		this.id_agencia = id_agencia;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.valor = valor;
	}

	public Integer getId_destino() {
		return id_destino;
	}

	public void setId_destino(Integer id_destino) {
		this.id_destino = id_destino;
	}

	public Integer getId_agencia() {
		return id_agencia;
	}

	public void setId_agencia(Integer id_agencia) {
		this.id_agencia = id_agencia;
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

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Destinos [id_destino=" + id_destino + ", id_agencia=" + id_agencia + ", pais=" + pais + ", estado="
				+ estado + ", cidade=" + cidade + ", valor=" + valor + "]";
	}
	
	
	
	
	
}
