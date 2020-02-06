package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Promotion
 *
 */
@Entity
@Table(name = "promotions")
@NamedQueries({ @NamedQuery(name = "Promotion.getAll", query = "Select p from Promotion p"),
	@NamedQuery(name = "Promotion.getById", query = "Select p from Promotion p where p.idPromotion = :pId") })
public class Promotion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPromotion;
	private String libelle;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="promotion_assoc_etudiant", joinColumns= @JoinColumn(name="promotionId"), inverseJoinColumns 				=@JoinColumn(name="etudiantId"))
	private List<Etudiant> listeEtudiants;

	@OneToMany(targetEntity=Cours.class, cascade=CascadeType.ALL, mappedBy="promotion")
	private List<Cours> listCours;
	
	public Promotion() {
	}//end ctor vide

	

	public Promotion(String libelle, List<Etudiant> listeEtudiants, List<Cours> listCours) {
		super();
		this.libelle = libelle;
		this.listeEtudiants = listeEtudiants;
		this.listCours = listCours;
	}



	public Promotion(int idPromotion, String libelle, List<Etudiant> listeEtudiants, List<Cours> listCours) {
		super();
		this.idPromotion = idPromotion;
		this.libelle = libelle;
		this.listeEtudiants = listeEtudiants;
		this.listCours = listCours;
	}



	public int getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}



	public List<Cours> getListCours() {
		return listCours;
	}



	public void setListCours(List<Cours> listCours) {
		this.listCours = listCours;
	}
	
   
}// end class