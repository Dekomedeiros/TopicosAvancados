package transportadora.dao.banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	
	private static Connection connection;

	public static Connection getConnection() {
		if(connection != null) {
			return connection;
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC","root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;

	}
	
}
