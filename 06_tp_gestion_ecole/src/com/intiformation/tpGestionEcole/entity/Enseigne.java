package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Enseigne
 *
 */
@Entity
@Table(name="enseignent")
public class Enseigne implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEnseigne; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="matiereId", referencedColumnName="idMatiere") // gestion de la fk
	private Matiere matiere;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="enseignantId", referencedColumnName="idEnseignant") // gestion de la fk
	private Enseignant enseignant;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="promotionId", referencedColumnName="idPromotion") // gestion de la fk
	private Promotion promotion;
	
	
	public Enseigne() {
		super();
	}//end ctor


	public Enseigne(Matiere matiere, Enseignant enseignant, Promotion promotion) {
		super();
		this.matiere = matiere;
		this.enseignant = enseignant;
		this.promotion = promotion;
	}


	public Enseigne(int idEnseigne, Matiere matiere, Enseignant enseignant, Promotion promotion) {
		super();
		this.idEnseigne = idEnseigne;
		this.matiere = matiere;
		this.enseignant = enseignant;
		this.promotion = promotion;
	}




	public int getIdEnseigne() {
		return idEnseigne;
	}


	public void setIdEnseigne(int idEnseigne) {
		this.idEnseigne = idEnseigne;
	}


	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	public Enseignant getEnseignant() {
		return enseignant;
	}


	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}


	public Promotion getPromotion() {
		return promotion;
	}


	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
	@Override
	public String toString() {
		return "Enseigne [idEnseigne=" + idEnseigne + ", matiere=" + matiere + ", enseignant=" + enseignant
				+ ", promotion=" + promotion + "]";
	}
   
}
