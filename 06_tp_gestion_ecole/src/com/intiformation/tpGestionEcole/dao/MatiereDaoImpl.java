package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.entity.Matiere;

public class MatiereDaoImpl implements IGestionEcoleDao<Matiere>{

	@Override
	public List<Matiere> getAll() {
		try {
			Query createQuery = em.createNamedQuery("Matiere.getAll");
			List<Matiere> resultList = createQuery.getResultList();

			return resultList;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// end get all

	@Override
	public Matiere getById(int id) {
		try {
			Query createQuery = em.createNamedQuery("Matiere.getById");
			createQuery.setParameter("pId", id);
			Matiere singleResult = (Matiere) createQuery.getSingleResult();

			return singleResult;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// End getbyid

	@Override
	public boolean add(Matiere t) {
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
	public boolean update(Matiere t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Matiere.getById");
			createQuery.setParameter("pId", t.getIdMatiere());
			Matiere matiereUpdate = (Matiere) createQuery.getSingleResult();
			matiereUpdate.setLibelle(t.getLibelle());
			matiereUpdate.setListCours(t.getListCours());
			

			em.merge(matiereUpdate);
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
			Query createQuery = em.createNamedQuery("Matiere.getById");
			createQuery.setParameter("pId", id);
			Matiere matiereDelete = (Matiere) createQuery.getSingleResult();
			em.remove(matiereDelete);
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
