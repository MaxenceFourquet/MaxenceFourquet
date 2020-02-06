package com.intiformation.tpGestionEcole.tool;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class DbConnection {

	private static EntityManager em;
	private static String pu_name;

	public static EntityManager getEntityManager() {

		if (em == null) {
			try {
				// 1. recup de l'EM
				pu_name = "06_tp_gestion_ecole";
				em = Persistence.createEntityManagerFactory(pu_name).createEntityManager();
			} catch (PersistenceException e) {
				System.out.println("la recup de l'em a échouée");
				e.printStackTrace();
				return null;
			} // end trycatch
		} // end if
		return em;
	}// end methode
}// End class
