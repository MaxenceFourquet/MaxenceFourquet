package com.intiformation.tpGestionEcole.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.intiformation.tpGestionEcole.tool.DbConnection;

public interface IGestionEcoleDao<T> {
	//Recup de la connexion à parti de l'utilitaire 'ConnexionMySql'
		public EntityManager em = DbConnection.getEntityManager();
		
		// déclaration des méthodes à exposer dans la DAO
		
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
			 * Ajoute un objet dans la base de données
			 * @param t
			 * @return
			 */
			public boolean add(T t);
			
			
			/**
			 * mise à jour d'un objet dans la base de données
			 * @param t
			 * @return
			 */
			public boolean update (T t);
			
			/**
			 * suppression d'un objet dans la base de données via son ID
			 * @param id
			 * @return
			 */
			public boolean delete(int id);
}
