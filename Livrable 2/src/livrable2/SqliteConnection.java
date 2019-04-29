package livrable2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {
	
	public static Connection dbConnector() {
		Connection conn = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:src/livrable2/Idehen_AbouAntoun_Albums.db");
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ERREUR : Driver manquant.");
		} catch (SQLException se) {
			System.out.println("ERREUR SQL :" + se);
		}
		
		return conn;
	}

}
