package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Administrateur
 *
 */
@Entity
@Table(name = "administrateurs")
@NamedQueries({ @NamedQuery(name = "Administrateur.getAll", query = "Select a from Administrateur a"),
		@NamedQuery(name = "Administrateur.getById", query = "Select a from Administrateur a where a.idAdministrateur = :pId"),
		@NamedQuery(name = "Administrateur.isExist", query = "SELECT count(e.idAdministrateur) FROM Administrateur e WHERE e.identifiant = :pIdentifiant and e.motDePasse = :pMdp") })
public class Administrateur implements Serializable {

	/*-----------------------------props-----------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrateur;
	private String identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String mail;

	/*---------------------------------------------------*/
	/*--------------------association--------------------*/
	/*---------------------------------------------------*/
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresseId", referencedColumnName = "idAdresse") // gestion de la fk
	private Adresse adresse;

	/*-----------------------------ctors-----------------------------*/
	public Administrateur() {
		super();
	}

	public Administrateur(int idAdministrateur, String identifiant, String motDePasse, String nom, String prenom,
			String mail) {
		super();
		this.idAdministrateur = idAdministrateur;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
	}

	public Administrateur(String identifiant, String motDePasse, String nom, String prenom, String mail,
			Adresse adresse) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
	}

	public Administrateur(int idAdministrateur, String identifiant, String motDePasse, String nom, String prenom,
			String mail, Adresse adresse) {
		super();
		this.idAdministrateur = idAdministrateur;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
	}

	/*-----------------------------getters/setters-----------------------------*/
	public int getIdAdministrateur() {
		return idAdministrateur;
	}

	public void setIdAdministrateur(int idAdministrateur) {
		this.idAdministrateur = idAdministrateur;
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
		return "Administrateur [idAdministrateur=" + idAdministrateur + ", identifiant=" + identifiant + ", motDePasse="
				+ motDePasse + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + "]";
	}

}// end class
