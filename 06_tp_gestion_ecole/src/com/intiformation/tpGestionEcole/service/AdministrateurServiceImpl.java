package com.intiformation.tpGestionEcole.service;

import java.util.List;

import com.intiformation.tpGestionEcole.dao.AdministrateurDaoImpl;
import com.intiformation.tpGestionEcole.entity.Administrateur;

public class AdministrateurServiceImpl implements IGestionEcoleService<Administrateur>{

	AdministrateurDaoImpl adminDaoImpl = new AdministrateurDaoImpl();
	@Override
	public List<Administrateur> findAll() {
		return adminDaoImpl.getAll();
	}

	@Override
	public Administrateur findById(int id) {
		return adminDaoImpl.getById(id);
	}

	@Override
	public boolean ajouter(Administrateur t) {
		return adminDaoImpl.add(t);
	}

	@Override
	public boolean modifier(Administrateur t) {
		return adminDaoImpl.update(t);
	}

	@Override
	public boolean supprimer(int id) {
		return adminDaoImpl.delete(id);
	}

	@Override
	public boolean isUtilisateurExist(String pLogin, String pMdp) {
		return adminDaoImpl.isUserExist(pLogin, pMdp);
	}

}//end class
