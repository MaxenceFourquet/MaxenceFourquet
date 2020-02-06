package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.entity.Aide;

public class AideDaoImpl implements IGestionEcoleDao<Aide> {

	@Override
	public List<Aide> getAll() {
		try {
			Query createQuery = em.createNamedQuery("Aide.getAll");
			List<Aide> resultList = createQuery.getResultList();

			return resultList;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// end get all

	@Override
	public Aide getById(int id) {
		try {
			Query createQuery = em.createNamedQuery("Aide.getById");
			createQuery.setParameter("pId", id);
			Aide singleResult = (Aide) createQuery.getSingleResult();

			return singleResult;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}//End getbyid

	@Override
	public boolean add(Aide t) {
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
	}//end methode add()

	@Override
	public boolean update(Aide t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Aide.getById");
			createQuery.setParameter("pId", t.getIdAide());
			Aide aideUpdate = (Aide) createQuery.getSingleResult();
			aideUpdate.setPage(t.getPage());
			aideUpdate.setContenu(t.getContenu());

			em.merge(aideUpdate);
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
			Query createQuery = em.createNamedQuery("Aide.getById");
			createQuery.setParameter("pId", id);
			Aide aideDelete = (Aide) createQuery.getSingleResult();
			em.remove(aideDelete);
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

}// End class
