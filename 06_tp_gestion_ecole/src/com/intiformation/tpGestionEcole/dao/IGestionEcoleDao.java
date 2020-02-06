package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.intiformation.tpGestionEcole.tool.DbConnection;

public interface IGestionEcoleDao<T> {
	//Recup de la connexion � parti de l'utilitaire 'ConnexionMySql'
		public EntityManager em = DbConnection.getEntityManager();
		
		// d�claration des m�thodes � exposer dans la DAO
		
			/**
			 * Recup de la liste des objets (liste des hotels, des chambres, ...etc)
			 * @return
			 */
			public List<T> getAll();
			
			/**
			 * Recup d'un objet par son ID
			 * @param id
			 * @return
			 */
			public T getById(int id);
			
			/**
			 * Ajoute un objet dans la base de donn�es
			 * @param t
			 * @return
			 */
			public boolean add(T t);
			
			
			/**
			 * mise � jour d'un objet dans la base de donn�es
			 * @param t
			 * @return
			 */
			public boolean update (T t);
			
			/**
			 * suppression d'un objet dans la base de donn�es via son ID
			 * @param id
			 * @return
			 */
			public boolean delete(int id);
}
