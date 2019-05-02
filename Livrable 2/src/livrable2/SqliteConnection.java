package livrable2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public void insertNouveau() {
        String sql = "INSERT INTO artistes(nom, photo) VALUES(?, ?)";
        //try (Connection conn = dbConnector();
        try (Connection conn = dbConnector();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "");
            pstmt.setString(2, "default.png");
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Un nouvelle artiste à été crée!");
            
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.CANCEL_OPTION);
        }
    }
 
	public void updateArtiste(int id, String nom, boolean membre, String imageIcon, String fonction) {
		String sql = "UPDATE artistes SET nom = ?, membre = ?, photo = ? WHERE id = ?";

		// try (Connection conn = this.dbConnector();
		try (Connection conn = dbConnector(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nom);
			pstmt.setBoolean(2, membre);
			pstmt.setString(3, imageIcon);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "L'artiste selectionné à été "+fonction +"!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.CANCEL_OPTION);
		}
	}

	public void deleteArtiste(int id) {
		String sql = "DELETE FROM artistes WHERE id = ?";
		// try (Connection conn = dbConnector();
		try (Connection conn = dbConnector(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.CANCEL_OPTION);
		}
	}
	
	public void remplacerPhoto(String photo, int id, String nom) {
		String sql = "UPDATE artistes SET photo = ? WHERE id = ?";
		try (Connection conn = dbConnector(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, photo);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "L'image par défaut a été appliqué à " + nom + "!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.CANCEL_OPTION);
		}
		
	}

}
