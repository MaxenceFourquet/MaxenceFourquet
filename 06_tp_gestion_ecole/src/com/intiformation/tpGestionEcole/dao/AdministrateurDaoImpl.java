package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.entity.Administrateur;
import com.intiformation.tpGestionEcole.entity.Aide;

public class AdministrateurDaoImpl implements IGestionEcoleDao<Administrateur> {

	@Override
	public List<Administrateur> getAll() {
		try {
			Query createQuery = em.createNamedQuery("Administrateur.getAll");
			List<Administrateur> resultList = createQuery.getResultList();

			return resultList;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// end get all

	@Override
	public Administrateur getById(int id) {
		try {
			Query createQuery = em.createNamedQuery("Administrateur.getById");
			createQuery.setParameter("pId", id);
			Administrateur singleResult = (Administrateur) createQuery.getSingleResult();

			return singleResult;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// End getbyid

	@Override
	public boolean add(Administrateur t) {
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
	public boolean update(Administrateur t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Administrateur.getById");
			createQuery.setParameter("pId", t.getIdAdministrateur());
			Administrateur administrateurUpdate = (Administrateur) createQuery.getSingleResult();
			administrateurUpdate.setIdentifiant(t.getIdentifiant());
			administrateurUpdate.setMotDePasse(t.getMotDePasse());
			administrateurUpdate.setNom(t.getNom());
			administrateurUpdate.setPrenom(t.getPrenom());
			administrateurUpdate.setMail(t.getMail());
			administrateurUpdate.setAdresse(t.getAdresse());

			em.merge(administrateurUpdate);
			tx.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}//end methode update()

	@Override
	public boolean delete(int id) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Administrateur.getById");
			createQuery.setParameter("pId", id);
			Administrateur administrateurDelete = (Administrateur) createQuery.getSingleResult();
			em.remove(administrateurDelete);
			tx.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}//end methode delete
	
	public boolean isUserExist(String pLogin, String pMdp) {

		try {
			// 2. recup d'une transaction
			Query createQuery = em.createNamedQuery("Administrateur.isExist");
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

}// End classe
