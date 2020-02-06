package com.intiformation.tpGestionEcole.service;

import java.util.List;

import com.intiformation.tpGestionEcole.dao.EtudiantDaoImpl;
import com.intiformation.tpGestionEcole.entity.Etudiant;

public class EtudiantServiceImpl implements IGestionEcoleService<Etudiant> {

	EtudiantDaoImpl etudiantDaoImpl = new EtudiantDaoImpl();
	@Override
	public List<Etudiant> findAll() {
		return etudiantDaoImpl.getAll();
	}

	@Override
	public Etudiant findById(int id) {
		return etudiantDaoImpl.getById(id);
	}

	@Override
	public boolean ajouter(Etudiant t) {
		return etudiantDaoImpl.add(t);
	}

	@Override
	public boolean modifier(Etudiant t) {
		return etudiantDaoImpl.update(t);
	}

	@Override
	public boolean supprimer(int id) {
		return etudiantDaoImpl.delete(id);
	}

	@Override
	public boolean isUtilisateurExist(String pLogin, String pMdp) {
		return etudiantDaoImpl.isUserExist(pLogin, pMdp);
	}

	

}// end class