package com.intiformation.tpGestionEcole.test;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.intiformation.tpGestionEcole.dao.AdministrateurDaoImpl;
import com.intiformation.tpGestionEcole.dao.AideDaoImpl;
import com.intiformation.tpGestionEcole.dao.EtudiantDaoImpl;
import com.intiformation.tpGestionEcole.entity.Administrateur;
import com.intiformation.tpGestionEcole.entity.Adresse;
import com.intiformation.tpGestionEcole.entity.Aide;
import com.intiformation.tpGestionEcole.entity.Cours;
import com.intiformation.tpGestionEcole.entity.Etudiant;
import com.intiformation.tpGestionEcole.entity.EtudiantCours;
import com.intiformation.tpGestionEcole.entity.Matiere;
import com.intiformation.tpGestionEcole.entity.Promotion;

public class AppTest {

	public static void main(String[] args) {
		
		Aide aide1 = new Aide(5, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus aliquet posuere nunc, et tempor turpis hendrerit rutrum. Phasellus sed dictum arcu.");
		Aide aide2 = new Aide(4, "Il faut rester concentré pendant une heure entière ");
		AideDaoImpl aideDaoImpl = new AideDaoImpl();
		if (aideDaoImpl.add(aide1)) {
			System.out.println("ajout aide 1 ok");
		} else {
			System.out.println("ajout aide 1 nok");
		}//end if
		
		if (aideDaoImpl.add(aide2)) {
			System.out.println("ajout aide 1 ok");
		} else {
			System.out.println("ajout aide 1 nok");
		}//end if

		
		if (aideDaoImpl.update(aide2)) {
			System.out.println("maj aide 2 ok");
		} else {
			System.out.println("maj aide 2 nok");
		}//end if
		
		Adresse adresse1 = new Adresse("18 rue de Naudet", "33170", "Gradignan");
		Administrateur admin1 = new Administrateur("admin1", "admin1", "GELINET", "Charles", "cgelinet@yahoo.fr", adresse1 );
		
		Adresse adresse2 = new Adresse("36 rue des bahutiers", "33000", "bordeaux");
		Administrateur admin2 = new Administrateur("admin2", "admin2", "FOURQUET", "Maxence", "maxence.fourquet@gmail.com", adresse2 );
		
		AdministrateurDaoImpl adminDao = new AdministrateurDaoImpl();
		adminDao.add(admin1);
		adminDao.add(admin2);
		
		
		//------------------------Ajout d'un etudiant-------------------------
		Matiere matiere1;
		
		Cours coursJavaSE;
		List<Cours> listCours = new ArrayList<>();
		
		matiere1 = new Matiere("JavaSE", listCours);
		
		List<Promotion> listPromo = new ArrayList<>();
		
		Etudiant etu1;
		List<Etudiant> listEtudiants = new ArrayList<>();
		Promotion promo1 = new Promotion("Masters2", listEtudiants, listCours);
		List<EtudiantCours> listetudiantscours = new ArrayList<>();
		Date date1 = new Date(2020, 01, 25);
		Date date2 = new Date(1994, 03, 25);
		 
				
		coursJavaSE = new Cours("L'heritage", date1, "90", "Apprentissage des notions d'heritage", matiere1, promo1, null);
				
				
		
		etu1 = new Etudiant("etu1", "123", "Titegoutte", "Corinne", "coco.titgoutte@gmail.com", "url photo trombi", date2, adresse1, listPromo, null);
		
		listEtudiants.add(etu1);
		listPromo.add(promo1);
		listCours.add(coursJavaSE);
		
		EtudiantDaoImpl etuImpl = new EtudiantDaoImpl();
		etuImpl.add(etu1);
		
	}// end main

}// end class
