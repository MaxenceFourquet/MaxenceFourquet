package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.entity.Administrateur;
import com.intiformation.tpGestionEcole.entity.Enseignant;

public class EnseignantDaoImpl implements IGestionEcoleDao<Enseignant> {

	@Override
	public List<Enseignant> getAll() {
		try {

			Query createQuery = em.createNamedQuery("Enseignant.getAll");
			List<Enseignant> resultList = createQuery.getResultList();
			return resultList;

		} catch (PersistenceException e) {
			e.printStackTrace();
		} // end catch
		finally {
			// em.close();
		}
		return null;
	}// end getAll()

	@Override
	public Enseignant getById(int id) {
		try {

			Query createQuery = em.createNamedQuery("Enseignant.getById");
			createQuery.setParameter("pId", id);
			Enseignant singleResult = (Enseignant) createQuery.getSingleResult();
			return singleResult;

		} catch (PersistenceException e) {
			e.printStackTrace();
		} // end catch
		finally {
			// em.close();
		}

		return null;
	}// end getById()

	@Override
	public boolean add(Enseignant t) {
		EntityTransaction tx = null;
		try {

			tx = em.getTransaction();
			tx.begin();

			em.persist(t);

			tx.commit();
			return true;

		} catch (PersistenceException e) {
			e.printStackTrace();
		} // end catch
		finally {
			// tx.close()
			// em.close();
		}
		return false;
	}// end methode add()

	@Override
	public boolean update(Enseignant t) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Enseignant.getById");
			createQuery.setParameter("pId", t.getIdEnseignant());
			Enseignant enseignantUpdate = (Enseignant) createQuery.getSingleResult();
			enseignantUpdate.setIdentifiant(t.getIdentifiant());
			enseignantUpdate.setMotDePasse(t.getMotDePasse());
			enseignantUpdate.setNom(t.getNom());
			enseignantUpdate.setPrenom(t.getPrenom());
			enseignantUpdate.setMail(t.getMail());
			enseignantUpdate.setAdresse(t.getAdresse());

			em.merge(enseignantUpdate);
			tx.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}// end update()

	@Override
	public boolean delete(int id) {
		EntityTransaction tx = null;
		try {
			// 2. recup d'une transaction
			tx = em.getTransaction();
			tx.begin();
			Query createQuery = em.createNamedQuery("Enseignant.getById");
			createQuery.setParameter("pId", id);
			Enseignant enseignantDelete = (Enseignant) createQuery.getSingleResult();
			em.remove(enseignantDelete);

			tx.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}// end delete()
	
	public boolean isUserExist(String pLogin, String pMdp) {
		
		try {
			// 2. recup d'une transaction
			Query createQuery = em.createNamedQuery("Enseignant.isExist");
			createQuery.setParameter("pIdentifiant", pLogin);
			createQuery.setParameter("pMdp", pMdp);
			
			int verifExist = (int) createQuery.getSingleResult();
			if (verifExist == 1) {
				return true;
			}//end if
	
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			// tx.close();
			// em.close();
		} // end try catch
		return false;
	}//End method isUserExist
}// end class