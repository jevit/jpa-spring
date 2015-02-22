package jv.jpatpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jv.jpatpl.dao.UtilisateurDaoImpl;
import jv.jpatpl.domain.Utilisateur;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// just for fun
		EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("punit");
		EntityManager entityManager = sessionFactory.createEntityManager();
		UtilisateurDaoImpl utilDao = new UtilisateurDaoImpl();
		utilDao.setEntityManager(entityManager);
		Utilisateur util = utilDao.get(1L);
		System.out.println(util.getFirstname());

	}
}
