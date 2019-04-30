package livrable2;


public class Artiste {
	private int id;
	private String nom;
	private boolean membre;
	private String photo;

	// Constructeur
	public Artiste(int id, String nom, boolean membre, String photo) {
		this.id = id;
		this.nom = nom;
		this.membre = membre;
		this.photo = photo;
	}

	// Constructeur pour la recherche et la suppression par numéro d'employé
	/*public Employe(String numero ){
			this.code= numero;
			this.nom= "";
			this.salaire= 0.0;
			this.profession= "";
		}*/

	// Accesseurs
	public int getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public boolean getMembre() {
		return this.membre;
	}

	public String getPhoto() {
		return this.photo;
	}
	
	public void setNom(String nNom) {
		this.nom = nNom;
	}
	public void setMembre(boolean nMembre) {
		this.membre = nMembre;
	}

}
