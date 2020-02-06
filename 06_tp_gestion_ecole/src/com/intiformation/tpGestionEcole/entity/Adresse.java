package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Adresse
 *
 */
@Entity
@Table(name = "adresses")
public class Adresse implements Serializable {

	/*-----------------------------props-----------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdresse;
	private String rue;
	private String cP;
	private String ville;
	
	/*-----------------------------ctors-----------------------------*/
	public Adresse() {
	}//end ctor


	public Adresse(String rue, String cP, String ville) {
		super();
		this.rue = rue;
		this.cP = cP;
		this.ville = ville;
	}


	public Adresse(int idAdresse, String rue, String cP, String ville) {
		super();
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.cP = cP;
		this.ville = ville;
	}

	/*-----------------------------getters/setters-----------------------------*/
	public int getIdAdresse() {
		return idAdresse;
	}


	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getcP() {
		return cP;
	}


	public void setcP(String cP) {
		this.cP = cP;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", rue=" + rue + ", cP=" + cP + ", ville=" + ville + "]";
	}
   
}//end 
