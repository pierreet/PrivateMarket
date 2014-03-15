package privatemarket.contrats.objet;

import javax.sql.DataSource;

public class Titre {
	DataSource dataSource = null;
	private int id;
	private double Prix;
	private double PrixActuel;
	private String DateCreation;
	private String DateFin;
	private int idEntreprise;
	private int idVendeur;
	private int idAcheteur;
	private String NomEntreprise;
	private String NomVendeur;
	//public static String _LISTE_OPERATIONS = "_LISTE_OPERATIONS";


	public Titre() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrix() {
		return Prix;
	}

	public void setPrix(Double prix) {
		Prix = prix;
	}

	public Double getPrixActuel() {
		return PrixActuel;
	}

	public void setPrixActuel(Double prix) {
		PrixActuel = prix;
	}

	public String getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(String dateCreation) {
		DateCreation = dateCreation;
	}

	public String getDateFin() {
		return DateFin;
	}

	public void setDateFin(String dateFin) {
		DateFin = dateFin;
	}

	public int getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public void setNomEntreprise(String a) {
		this.NomEntreprise = a;
	}
	
	public String getNomEntreprise(){
		return this.NomEntreprise;
	}
	public String getNomVendeur(){
		return this.NomVendeur;
	}
	
	public int getIdVendeur() {
		return idVendeur;
	}

	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}

	public void setNomVendeur(String a) {
		this.NomVendeur = a;
	}

	public void setIdAcheteur(int idA) {
		this.idAcheteur = idA;
	}

	public int getIdAcheteur() {
		return idAcheteur;
	}

	

}