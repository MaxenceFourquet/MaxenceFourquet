package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.entity.Etudiant;
import com.intiformation.tpGestionEcole.entity.Promotion;

public class PromotionDaoImpl implements IGestionEcoleDao<Promotion> {

	@Override
	public List<Promotion> getAll() {
		try {
			Query createQuery = em.createNamedQuery("Promotion.getAll");
			List<Promotion> resultList = createQuery.getResultList();

			return resultList;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// end get all

	@Override
	public Promotion getById(int id) {
		try {
			Query createQuery = em.createNamedQuery("Promotion.getById");
			createQuery.setParameter("pId", id);
			Promotion singleResult = (Promotion) createQuery.getSingleResult();

			return singleResult;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// End getbyid

	@Override
	public boolean add(Promotion t) {
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
	public boolean update(Promotion t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Promotion.getById");
			createQuery.setParameter("pId", t.getIdPromotion());
			Promotion promotionUpdate = (Promotion) createQuery.getSingleResult();
			promotionUpdate.setLibelle(t.getLibelle());
			promotionUpdate.setListeEtudiants(t.getListeEtudiants());
			promotionUpdate.setListCours(t.getListCours());

			em.merge(promotionUpdate);
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
			Query createQuery = em.createNamedQuery("Promotion.getById");
			createQuery.setParameter("pId", id);
			Promotion promotionDelete = (Promotion) createQuery.getSingleResult();
			em.remove(promotionDelete);
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

}//end class