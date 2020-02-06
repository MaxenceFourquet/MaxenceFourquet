package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.entity.Etudiant;
import com.intiformation.tpGestionEcole.entity.EtudiantCours;

public class EtudiantCoursDaoImpl implements IGestionEcoleDao<EtudiantCours> {

	@Override
	public List<EtudiantCours> getAll() {
		try {
			Query createQuery = em.createNamedQuery("EtudiantCours.getAll");
			List<EtudiantCours> resultList = createQuery.getResultList();

			return resultList;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// end get all

	@Override
	public EtudiantCours getById(int id) {
		try {
			Query createQuery = em.createNamedQuery("EtudiantCours.getById");
			createQuery.setParameter("pId", id);
			EtudiantCours singleResult = (EtudiantCours) createQuery.getSingleResult();

			return singleResult;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// em.close();
		} // end try catch
		return null;
	}// End getbyid

	@Override
	public boolean add(EtudiantCours t) {
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
	public boolean update(EtudiantCours t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("EtudiantCours.getById");
			createQuery.setParameter("pId", t.getIdEtudiantsCours());
			EtudiantCours etudiantCoursUpdate = (EtudiantCours) createQuery.getSingleResult();
			etudiantCoursUpdate.setMotif(t.getMotif());
			etudiantCoursUpdate.setCours(t.getCours());
			etudiantCoursUpdate.setEtudiant(t.getEtudiant());
			etudiantCoursUpdate.setIdEtudiantsCours(t.getIdEtudiantsCours());


			em.merge(etudiantCoursUpdate);
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
			Query createQuery = em.createNamedQuery("EtudiantCours.getById");
			createQuery.setParameter("pId", id);
			EtudiantCours etudiantCoursDelete = (EtudiantCours) createQuery.getSingleResult();
			em.remove(etudiantCoursDelete);
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
