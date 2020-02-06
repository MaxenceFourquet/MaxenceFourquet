package com.intiformation.tpGestionEcole.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.intiformation.tpGestionEcole.service.AdministrateurServiceImpl;
import com.intiformation.tpGestionEcole.service.EnseignantServiceImpl;
import com.intiformation.tpGestionEcole.service.EtudiantServiceImpl;
import com.intiformation.tpGestionEcole.tool.SessionUtil;

/**
 * maagedBean pour l'authentification d'un utilisateur
 * 
 * @author IN-BR-003
 *
 */

@ManagedBean(name = "authentificationBean")
@SessionScoped
public class AuthentificationBean implements Serializable {

	/*----------------------props----------------------*/
	private String identifiant;
	private String motDePasse;
	// service
	private EtudiantServiceImpl etudiantServiceImpl;
	private AdministrateurServiceImpl adminServiceImpl;
	private EnseignantServiceImpl enseignantServiceImpl;

	/*----------------------ctors----------------------*/

	/**
	 * ctor vide
	 */
	public AuthentificationBean() {
		etudiantServiceImpl = new EtudiantServiceImpl();
		adminServiceImpl = new AdministrateurServiceImpl();
		enseignantServiceImpl = new EnseignantServiceImpl();
	}
	/*----------------------méthodes----------------------*/

	/**
	 * permet de faire connecter un tuilsatuer à son espace avec la création d'une
	 * session Http
	 * 
	 * @return
	 */
	public String connecterUtilisateur() {
		// 1. verif si l'utilisateur existe dans la bdd
		if (etudiantServiceImpl.isUtilisateurExist(identifiant, motDePasse)) {
			// => user exists
			// => 1.2.création de la session utilisateur
			HttpSession session1 = SessionUtil.getUserSession();

			// 1.2.1. sauvegarde du login dans la session
			session1.setAttribute("user_login", identifiant);

			// 1.3. renvoi de la page de redirection
			return "accueilEtudiant.xhtml";
		} else if (adminServiceImpl.isUtilisateurExist(identifiant, motDePasse)) {
			// => user exists
			// => 1.2.création de la session utilisateur
			HttpSession session2 = SessionUtil.getUserSession();

			// 1.2.1. sauvegarde du login dans la session
			session2.setAttribute("user_login", identifiant);

			// 1.3. renvoi de la page de redirection
			return "accueilAdministrateur.xhtml";
		} else if (enseignantServiceImpl.isUtilisateurExist(identifiant, motDePasse)) {
			// => user exists
			// => 1.2.création de la session utilisateur
			HttpSession session3 = SessionUtil.getUserSession();

			// 1.2.1. sauvegarde du login dans la session
			session3.setAttribute("user_login", identifiant);

			// 1.3. renvoi de la page de redirection
			return "accueilEnseignant.xhtml";
		} else {
			// => user not exists
			// 1.4. message d'erreur vers la vue
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "echec authentification",
					"l'utilisateur n'est pas connu dans la bdd"));
			// 1.5 redirection
			return "authentification.xhtml";
		} // end if else

	}// end connecterUtilisateur

	/**
	 * permet de déconnecter un utilisateur de son espace et la destruction de sa
	 * session
	 * 
	 * @return
	 */
	public String deconnecterUtilisateur() {
		/* +++++++++++++++++++++++++++++++++++++++++ */
		/* +++++++ Deconnexion du conseiller++++++++ */
		/* +++++++++++++++++++++++++++++++++++++++++ */
		/**
		 * deconnexion = destruction de la session donc de l'objet HttpSession
		 */
		// 1. recup de la session du conseillé
		HttpSession session = SessionUtil.getUserSession();// on recup la session mais si la session n'existe pas on
															// n'en crée pas une

		// 2. recup du param passé dans la requete destroy
		session.invalidate();

		// 3.deconnexion du conseiller

		return "authentification.xhtml";
	}// end deconnecterUtilisateur

	/*----------------------getters setters----------------------*/

	/**
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant
	 *            the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse
	 *            the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}// end class
