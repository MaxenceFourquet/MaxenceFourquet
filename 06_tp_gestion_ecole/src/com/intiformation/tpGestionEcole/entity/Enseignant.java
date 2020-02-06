package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Enseignant
 *
 */
@Entity
@Table(name = "enseignants")
@NamedQueries({ @NamedQuery(name = "Enseignant.getAll",query="SELECT e FROM Enseignant e"), @NamedQuery(name="Enseignant.getById",query="SELECT e FROM Enseignant e WHERE e.idEnseignant = :pId"), @NamedQuery(name="Enseignant.isExist",query="SELECT count(e.idEnseignant) FROM Enseignant e WHERE e.identifiant = :pIdentifiant and e.motDePasse = :pMdp")})
public class Enseignant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEnseignant;
	private String identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String mail;
	
	/*--------------------------------------------*/
	/* ---------------Association ---------------- */
	/*--------------------------------------------*/
	/**
	 * <pre>
	 * Type de la relation : Une personne associé à une adresse : One Personne to One Adresse => @OneToOne
	 * 
	 * >> relation de cascade avec (cascade=CascadeType.PERSIST) : ajout de la personne -> ajout de l'adresse associé
	 * </pre>
	 */
	@OneToOne(cascade = CascadeType.ALL) // relation unidirectionnelle 1/1
	@JoinColumn(name = "adresseId", referencedColumnName = "idAdresse") // gestion de la Foreign key
	private Adresse adresse;

	public Enseignant() {
	}// end ctor vide

	public Enseignant(int idEnseignant, String identifiant, String motDePasse, String nom, String prenom, String mail) {
		super();
		this.idEnseignant = idEnseignant;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

	public Enseignant(String identifiant, String motDePasse, String nom, String prenom, String mail) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}
	
	

	public Enseignant(int idEnseignant, String identifiant, String motDePasse, String nom, String prenom, String mail,
			Adresse adresse) {
		super();
		this.idEnseignant = idEnseignant;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
	}

	public Enseignant(String identifiant, String motDePasse, String nom, String prenom, String mail, Adresse adresse) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
	}

	public int getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", identifiant=" + identifiant + ", motDePasse="
				+ motDePasse + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + "]";
	}
	
	
	 
}// end class