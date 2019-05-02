package livrable2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SqliteConnection {
	
	public static Connection dbConnector() {
		Connection conn = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:src/livrable2/Idehen_AbouAntoun_Albums.db");
			
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null,"ERREUR : Driver manquant.", "Erreur", JOptionPane.OK_OPTION);
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "ERREUR SQL :" + se, "Erreur", JOptionPane.OK_OPTION);
		}
		
		return conn;
	}

}
