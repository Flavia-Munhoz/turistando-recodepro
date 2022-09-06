package application;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		//Agencia agencia = new Agencia();
		//agencia.cadastrarAgencia("12.345.678/0001-11", "Turistando", "51998833290", "agencia@turistando.com.br");
		
		Destinos destino = new Destinos();
		//destino.cadastrarDestino("Brasil", "Bahia", "Salvador", 875);
		
		//Promo promo = new Promo();
		//promo.cadastrarPromo(15, 1);
		
		//destino.consultarDestinos();
		destino.updateDestino(1, "Porto Seguro");
	}

}
