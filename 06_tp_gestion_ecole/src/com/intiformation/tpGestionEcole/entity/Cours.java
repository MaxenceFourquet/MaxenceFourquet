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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Cours
 *
 */
@Entity
@Table(name= "cours")
@NamedQueries({ @NamedQuery(name = "Cours.getAll", query = "Select c from Cours c"),
	@NamedQuery(name = "Cours.getById", query = "Select c from Cours c where c.idCours = :pId") })
public class Cours implements Serializable {

	/*-----------------------------props-----------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCours;
	private String libelle;
	private Date date;
	private String duree;
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "matiereId", referencedColumnName="idMatiere")
	private Matiere matiere;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "promotionId", referencedColumnName="idPromotion")
	private Promotion promotion;
	
	@OneToMany(targetEntity=EtudiantCours.class, cascade=CascadeType.ALL, mappedBy="cours")
	private List<EtudiantCours> listEtudiantCours;
	
	public Cours() {
		super();
	}//end main 
	
	

	
	/*-----------------------------getters setters-----------------------------*/

	public Cours(String libelle, Date date, String duree, String description, Matiere matiere, Promotion promotion,
			List<EtudiantCours> listEtudiantCours) {
		super();
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
		this.matiere = matiere;
		this.promotion = promotion;
		this.listEtudiantCours = listEtudiantCours;
	}




	public Cours(int idCours, String libelle, Date date, String duree, String description, Matiere matiere,
			Promotion promotion, List<EtudiantCours> listEtudiantCours) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
		this.matiere = matiere;
		this.promotion = promotion;
		this.listEtudiantCours = listEtudiantCours;
	}




	public int getIdCours() {
		return idCours;
	}

	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	public Promotion getPromotion() {
		return promotion;
	}


	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


	public List<EtudiantCours> getListEtudiantCours() {
		return listEtudiantCours;
	}


	public void setListEtudiantCours(List<EtudiantCours> listEtudiantCours) {
		this.listEtudiantCours = listEtudiantCours;
	}


	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", libelle=" + libelle + ", date=" + date + ", duree=" + duree
				+ ", description=" + description + "]";
	}
   
	
}//end class
