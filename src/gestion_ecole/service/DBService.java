package gestion_ecole.service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

//Classe de service pour les actions de la base de donnée
public class DBService {
	private Connection connection;
	public DBService() throws Exception {
		
		// props permet de charger les propriétes dans le ficher conf.properties
		Properties props = new Properties();
		try( FileInputStream fs = new FileInputStream("conf.properties") ){
			props.load(fs);
		}
		Class.forName(props.getProperty("jdbc.driver.class"));
		
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		this.connection = DriverManager.getConnection(url, username, password);
		System.out.println("connected to database");
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public void createNewStudent(String firstname, String lastname) throws SQLException {
		String requete = "INSERT INTO student (firstname, lastname) VALUES ('".concat(firstname).concat("','").concat(lastname).concat("')");
		try ( Statement statement = this.getConnection().createStatement() ){
			statement.executeUpdate(requete);
		}
	}
	public void deleteStudent(int id) throws SQLException {
		String requete = "DELETE FROM student WHERE id="+ id;
		try ( Statement statement = this.getConnection().createStatement() ){
			statement.executeUpdate(requete);
		}
	}
	public ResultSet getAllStudent() throws SQLException {
		String requete = "SELECT * FROM student";
		try (Statement statement = this.getConnection().createStatement()) {
			return statement.executeQuery(requete);
		}
	}
}
