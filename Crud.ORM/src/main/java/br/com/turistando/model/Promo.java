package br.com.turistando.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_promo;
	private Integer id_destino;
	private Integer valorDesconto;
	
	public Promo() {
		
	}
	
	public Promo(Integer id_promo, Integer id_destino, Integer valorDesconto) {
		super();
		this.id_promo = id_promo;
		this.id_destino = id_destino;
		this.valorDesconto = valorDesconto;
	}
	
	public Promo(Integer id_destino, Integer valorDesconto) {
		this.id_destino = id_destino;
		this.valorDesconto = valorDesconto;
	}

	public Integer getId_promo() {
		return id_promo;
	}

	public void setId_promo(Integer id_promo) {
		this.id_promo = id_promo;
	}

	public Integer getId_destino() {
		return id_destino;
	}

	public void setId_destino(Integer id_destino) {
		this.id_destino = id_destino;
	}

	public Integer getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Integer valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	@Override
	public String toString() {
		return "Promo [id_promo=" + id_promo + ", id_destino=" + id_destino + ", valorDesconto=" + valorDesconto + "]";
	}
	
	
}
