package livrable2;


public class Album {
	private int idAlbum;
	private int idArtiste;
	private String titre;
	private String genre;
	private int annee;
	private String image;

	
	public Album(int idAlbum, int idArtiste, String titre, String genre, int annee, String image) {
		this.idAlbum = idAlbum;
		this.idArtiste = idArtiste;
		this.titre = titre;
		this.genre = genre;
		this.annee = annee;
		this.image = image;
	}

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
