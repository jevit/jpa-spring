package jv.jpatpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jv.jpatpl.dao.UtilisateurDao;
import jv.jpatpl.domain.Utilisateur;

public class UtilisateurDAOTest extends WebAppContext {

	@PersistenceContext(unitName = "punit")
	private EntityManager entityManager;

	@Autowired
	UtilisateurDao utilisateurDao;

	@Test
	public void testmethod() {
		Utilisateur util = utilisateurDao.get(1L);
		Assert.assertEquals(1L, (long) util.getId());
	}
}
