package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.entity.Administrateur;
import com.intiformation.tpGestionEcole.entity.Etudiant;

public class EtudiantDaoImpl implements IGestionEcoleDao<Etudiant> {

	@Override
	public List<Etudiant> getAll() {
		try {
			Query createQuery = em.createNamedQuery("Etudiant.getAll");
			List<Etudiant> resultList = createQuery.getResultList();

			return resultList;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// end get all

	@Override
	public Etudiant getById(int id) {
		try {
			Query createQuery = em.createNamedQuery("Etudiant.getById");
			createQuery.setParameter("pId", id);
			Etudiant singleResult = (Etudiant) createQuery.getSingleResult();

			return singleResult;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// End getbyid

	@Override
	public boolean add(Etudiant t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			em.persist(t);
			tx.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}// end methode add()

	@Override
	public boolean update(Etudiant t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Etudiant.getById");
			createQuery.setParameter("pId", t.getIdEtudiant());
			Etudiant etudiantUpdate = (Etudiant) createQuery.getSingleResult();
			etudiantUpdate.setIdentifiant(t.getIdentifiant());
			etudiantUpdate.setMotDePasse(t.getMotDePasse());
			etudiantUpdate.setNom(t.getNom());
			etudiantUpdate.setPrenom(t.getPrenom());
			etudiantUpdate.setMail(t.getMail());
			etudiantUpdate.setPhoto(t.getPhoto());
			etudiantUpdate.setDateDeNaissance(t.getDateDeNaissance());
			etudiantUpdate.setAdresse(t.getAdresse());
			etudiantUpdate.setListPromo(t.getListPromo());
			etudiantUpdate.setListEtudiantCours(t.getListEtudiantCours());

			em.merge(etudiantUpdate);
			tx.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}// end methode update()

	@Override
	public boolean delete(int id) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Etudiant.getById");
			createQuery.setParameter("pId", id);
			Etudiant etudiantDelete = (Etudiant) createQuery.getSingleResult();
			em.remove(etudiantDelete);
			tx.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}// end methode delete

	public boolean isUserExist(String pLogin, String pMdp) {

		try {
			// 2. recup d'une transaction
			Query createQuery = em.createNamedQuery("Etudiant.isExist");
			createQuery.setParameter("pIdentifiant", pLogin);
			createQuery.setParameter("pMdp", pMdp);

			int verifExist = (int) createQuery.getSingleResult();
			if (verifExist == 1) {
				return true;
			} // end if

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}// End method isUserExist

}// End class
