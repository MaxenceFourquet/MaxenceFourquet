package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.entity.Cours;
import com.intiformation.tpGestionEcole.entity.Promotion;

public class CoursDaoImpl implements IGestionEcoleDao<Cours>{

	@Override
	public List<Cours> getAll() {
		try {
			Query createQuery = em.createNamedQuery("Cours.getAll");
			List<Cours> resultList = createQuery.getResultList();

			return resultList;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// end get all

	@Override
	public Cours getById(int id) {
		try {
			Query createQuery = em.createNamedQuery("Cours.getById");
			createQuery.setParameter("pId", id);
			Cours singleResult = (Cours) createQuery.getSingleResult();

			return singleResult;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// End getbyid

	@Override
	public boolean add(Cours t) {
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
	public boolean update(Cours t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Cours.getById");
			createQuery.setParameter("pId", t.getIdCours());
			Cours coursUpdate = (Cours) createQuery.getSingleResult();
			coursUpdate.setLibelle(t.getLibelle());
			coursUpdate.setDate(t.getDate());
			coursUpdate.setDuree(t.getDuree());
			coursUpdate.setDescription(t.getDescription());
			coursUpdate.setPromotion(t.getPromotion());
			coursUpdate.setMatiere(t.getMatiere());
			coursUpdate.setListEtudiantCours(t.getListEtudiantCours());
			

			em.merge(coursUpdate);
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
			Query createQuery = em.createNamedQuery("Cours.getById");
			createQuery.setParameter("pId", id);
			Cours coursDelete = (Cours) createQuery.getSingleResult();
			em.remove(coursDelete);
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
}// end class