package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Etudiant
 *
 */
@Entity
@Table(name = "etudiants")
@NamedQueries({ @NamedQuery(name = "Etudiant.getAll", query = "Select e from Etudiant e"),
		@NamedQuery(name = "Etudiant.getById", query = "Select e from Etudiant e where e.idEtudiant = :pId"),
		@NamedQuery(name = "Etudiant.isExist", query = "SELECT count(e.idEtudiant) FROM Etudiant e WHERE e.identifiant = :pIdentifiant and e.motDePasse = :pMdp") })
public class Etudiant implements Serializable {

	/*-----------------------------props-----------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEtudiant;
	private String identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String mail;
	private String photo;
	private Date dateDeNaissance;

	/*---------------------------------------------------*/
	/*--------------------association--------------------*/
	/*---------------------------------------------------*/
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adresseId", referencedColumnName = "idAdresse") // gestion de la fk
	private Adresse adresse;

	@ManyToMany(mappedBy = "listeEtudiants", cascade = CascadeType.ALL)
	private List<Promotion> listPromo;

	@OneToMany(targetEntity = EtudiantCours.class, cascade = CascadeType.ALL, mappedBy = "etudiant")
	private List<EtudiantCours> listEtudiantCours;

	/*-----------------------------ctors-----------------------------*/
	public Etudiant() {
		super();
	}

	public Etudiant(String identifiant, String motDePasse, String nom, String prenom, String mail, String photo,
			Date dateDeNaissance, Adresse adresse, List<Promotion> listPromo, List<EtudiantCours> listEtudiantCours) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.listPromo = listPromo;
		this.listEtudiantCours = listEtudiantCours;
	}

	public Etudiant(int idEtudiant, String identifiant, String motDePasse, String nom, String prenom, String mail,
			String photo, Date dateDeNaissance, Adresse adresse, List<Promotion> listPromo,
			List<EtudiantCours> listEtudiantCours) {
		super();
		this.idEtudiant = idEtudiant;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.listPromo = listPromo;
		this.listEtudiantCours = listEtudiantCours;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Promotion> getListPromo() {
		return listPromo;
	}

	public void setListPromo(List<Promotion> listPromo) {
		this.listPromo = listPromo;
	}

	public List<EtudiantCours> getListEtudiantCours() {
		return listEtudiantCours;
	}

	public void setListEtudiantCours(List<EtudiantCours> listEtudiantCours) {
		this.listEtudiantCours = listEtudiantCours;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", identifiant=" + identifiant + ", motDePasse=" + motDePasse
				+ ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", photo=" + photo + ", dateDeNaissance="
				+ dateDeNaissance + "]";
	}

}// end class
