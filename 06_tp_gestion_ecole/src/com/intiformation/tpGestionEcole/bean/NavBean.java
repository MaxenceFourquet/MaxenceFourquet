package com.intiformation.tpGestionEcole.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="navBean")
@SessionScoped
public class NavBean implements Serializable{
	

	public NavBean() {
		// TODO Auto-generated constructor stub
	}
	/*________________________méthodes______________________*/
	public String navVersAccueilEtudiant() {
		return "navAccueilAdmin";	
	}//end methode 
	
	public String navVersAccueilAdmin() {
		return "navAccueilEtudiant";	
	}//end methode 
	
	public String navVersAccueilEnseignant() {
		return "navAccueilEnseignant";	
	}//end methode 
	
}//end class
