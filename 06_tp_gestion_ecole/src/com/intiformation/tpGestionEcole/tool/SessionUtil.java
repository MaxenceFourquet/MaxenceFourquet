package com.intiformation.tpGestionEcole.tool;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Utilitaire pour la gestion de la session utilisateur <br>
 * @author IN-BR-003
 *
 */
public class SessionUtil {

	/**
	 * permet de recuperer une session http pour un utilisateur 
	 * @return
	 */
	public static HttpSession getUserSession() {
		
		//1.recup du context de JSF
		FacesContext context = FacesContext.getCurrentInstance(); // autre contexte : contexte externe: concerne l'ensempble avec session
		
		//2. recup de la session
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		
		//3.renvoi de la session 
		
		return session;
		
	}//end getUserSession
	
}//end class