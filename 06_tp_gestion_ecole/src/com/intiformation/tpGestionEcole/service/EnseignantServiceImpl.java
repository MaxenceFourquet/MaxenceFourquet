package com.intiformation.tpGestionEcole.service;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.intiformation.tpGestionEcole.dao.EnseignantDaoImpl;
import com.intiformation.tpGestionEcole.entity.Enseignant;

public class EnseignantServiceImpl implements IGestionEcoleService<Enseignant>{
	
	private EnseignantDaoImpl enseignantDaoImpl = new EnseignantDaoImpl();

	@Override
	public List<Enseignant> findAll() {
		
		return enseignantDaoImpl.getAll();
	}

	@Override
	public Enseignant findById(int id) {
		return enseignantDaoImpl.getById(id);
	}

	@Override
	public boolean ajouter(Enseignant t) {
		return enseignantDaoImpl.add(t);
	}

	@Override
	public boolean modifier(Enseignant t) {
		return enseignantDaoImpl.update(t);
	}

	@Override
	public boolean supprimer(int id) {
		return enseignantDaoImpl.delete(id);
	}

	@Override
	public boolean isUtilisateurExist(String pLogin, String pMdp) {
		return enseignantDaoImpl.isUserExist(pLogin, pMdp);
	}// end isUtilisateurexist

}//end class
