package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EtudiantCours
 *
 */
@Entity
@Table(name="etudiantscours")
@NamedQueries({ @NamedQuery(name = "EtudiantCours.getAll", query = "Select e from EtudiantCours e"),
	@NamedQuery(name = "EtudiantCours.getById", query = "Select e from EtudiantCours e where e.IdEtudiantsCours = :pId") })
public class EtudiantCours implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdEtudiantsCours;
	private boolean abscence;
	private String motif;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "coursId", referencedColumnName="idCours")
	private Cours cours;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "etudiantId", referencedColumnName="idEtudiant")
	private Etudiant etudiant;

	public EtudiantCours() {
		super();
	}

	public EtudiantCours(boolean abscence, String motif, Cours cours, Etudiant etudiant) {
		super();
		this.abscence = abscence;
		this.motif = motif;
		this.cours = cours;
		this.etudiant = etudiant;
	}

	public EtudiantCours(int idEtudiantsCours, boolean abscence, String motif, Cours cours, Etudiant etudiant) {
		super();
		IdEtudiantsCours = idEtudiantsCours;
		this.abscence = abscence;
		this.motif = motif;
		this.cours = cours;
		this.etudiant = etudiant;
	}

	public int getIdEtudiantsCours() {
		return IdEtudiantsCours;
	}

	public void setIdEtudiantsCours(int idEtudiantsCours) {
		IdEtudiantsCours = idEtudiantsCours;
	}

	public boolean isAbscence() {
		return abscence;
	}

	public void setAbscence(boolean abscence) {
		this.abscence = abscence;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "EtudiantCours [IdEtudiantsCours=" + IdEtudiantsCours + ", abscence=" + abscence + ", motif=" + motif
				+ ", cours=" + cours + ", etudiant=" + etudiant + "]";
	}
   
}//end class
