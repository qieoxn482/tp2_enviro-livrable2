package livrable2;

import javax.swing.ImageIcon;

public class Album {
	private int idAlbum;
	private int idArtiste;
	private String titre;
	private String genre;
	private int annee;
	private String image;

	// Constructeur
	public Album(int idAlbum, int idArtiste, String titre, String genre, int annee, String image) {
		this.idAlbum = idAlbum;
		this.idArtiste = idArtiste;
		this.titre = titre;
		this.genre = genre;
		this.annee = annee;
		this.image = image;
	}

	// Constructeur pour la recherche et la suppression par numéro d'employé
	/*public Employe(String numero ){
			this.code= numero;
			this.nom= "";
			this.salaire= 0.0;
			this.profession= "";
		}*/

	// Accesseurs
	public int getIdAlbum() {
		return this.idAlbum;
	}

	public int getIdArtiste() {
		return this.idArtiste;
	}

	public String getTitre() {
		return this.titre;
	}
	
	public String getGenre() {
		return this.genre;
	}

	public int getAnnee() {
		return this.annee;
	}
	
	public String getImage() {
		return this.image;
	}
	
	
	@Override
	public String toString() {
		return getAnnee() + " - " + getTitre();
		
		
	}
	
	
}
