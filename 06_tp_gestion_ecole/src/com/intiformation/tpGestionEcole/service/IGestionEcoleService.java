package com.intiformation.tpGestionEcole.service;

import java.util.List;

public interface IGestionEcoleService<T> {
	/**
	 * Recup de la liste des objets (liste des hotels, des chambres, ...etc)
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * Recup d'un objet par son ID
	 * @param id
	 * @return
	 */
	public T findById(int id);
	
	/**
	 * Ajoute un objet dans la base de donn�es
	 * @param t
	 * @return
	 */
	public boolean ajouter(T t);
	
	
	/**
	 * mise � jour d'un objet dans la base de donn�es
	 * @param t
	 * @return
	 */
	public boolean modifier (T t);
	
	/**
	 * suppression d'un objet dans la base de donn�es via son ID
	 * @param id
	 * @return
	 */
	public boolean supprimer(int id);
	
	/**
	 * m�thode qui permet l'authentification d'un utilisateur du site
	 * @param pLogin
	 * @param pMdp
	 * @return
	 */
	public boolean isUtilisateurExist(String pLogin, String pMdp);



}//end interface
