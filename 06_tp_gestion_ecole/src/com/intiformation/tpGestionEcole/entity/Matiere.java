package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Matiere
 *
 */
@Entity
@Table(name = "matieres")
@NamedQueries({ @NamedQuery(name = "Matiere.getAll", query = "Select m from Matiere m"),
	@NamedQuery(name = "Matiere.getById", query = "Select m from Matiere m where m.idMatiere = :pId") })
public class Matiere implements Serializable {

	/*-----------------------------props-----------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMatiere;
	private String libelle;
	
	@OneToMany(targetEntity=Cours.class, cascade=CascadeType.ALL, mappedBy="matiere")
	private List<Cours> listCours;

	/*-----------------------------ctors-----------------------------*/
	public Matiere() {
	}



	public Matiere(String libelle, List<Cours> listCours) {
		super();
		this.libelle = libelle;
		this.listCours = listCours;
	}



	public Matiere(int idMatiere, String libelle, List<Cours> listCours) {
		super();
		this.idMatiere = idMatiere;
		this.libelle = libelle;
		this.listCours = listCours;
	}



	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Cours> getListCours() {
		return listCours;
	}



	public void setListCours(List<Cours> listCours) {
		this.listCours = listCours;
	}



	@Override
	public String toString() {
		return "Matiere [idMatiere=" + idMatiere + ", libelle=" + libelle + "]";
	}
   
}//End class
