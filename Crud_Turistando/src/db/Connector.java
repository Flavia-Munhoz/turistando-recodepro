package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Connector {
	protected String server;
	protected String db;
	protected String url;
	protected String user;
	protected String password;
	protected String tb_agencia, tb_destinos, tb_promo;
	protected Connection connection;
	
	public Connector() throws SQLException{
		this.server = "localhost";
		this.db = "agencia";
		this.url = "jdbc:mysql://" + server + "/" + db;
		this.user = "root";
		this.password = "123456";
		this.tb_agencia = "agencia";
		this.tb_destinos = "destinos";
		this.tb_promo = "promo";
		//Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(url, user, password);
	}
	
}
