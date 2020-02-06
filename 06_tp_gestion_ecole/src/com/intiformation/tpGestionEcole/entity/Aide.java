package com.intiformation.tpGestionEcole.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aide
 *
 */
@Entity
@Table(name = "aides")
@NamedQueries({ @NamedQuery(name = "Aide.getAll", query = "Select a from Aide a"),
		@NamedQuery(name = "Aide.getById", query = "Select a from Aide a where a.idAide = :pId") })
public class Aide implements Serializable {

	/*-----------------------------props-----------------------------*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAide;
	private int page;
	private String contenu;

	/*-----------------------------ctors-----------------------------*/
	public Aide() {
	}// End ctor vie

	public Aide(int page, String contenu) {
		super();
		this.page = page;
		this.contenu = contenu;
	}

	public Aide(int idAide, int page, String contenu) {
		super();
		this.idAide = idAide;
		this.page = page;
		this.contenu = contenu;
	}

	/*-----------------------------getters/setters-----------------------------*/

	public int getIdAide() {
		return idAide;
	}

	public void setIdAide(int idAide) {
		this.idAide = idAide;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "Aide [idAide=" + idAide + ", page=" + page + ", contenu=" + contenu + "]";
	}

}
