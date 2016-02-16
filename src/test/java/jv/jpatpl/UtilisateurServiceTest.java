package jv.jpatpl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import jv.jpatpl.dao.UtilisateurDao;
import jv.jpatpl.domain.Person;
import jv.jpatpl.service.PersonService;
import jv.jpatpl.service.UtilisateurService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/application-context-test.xml" })
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class UtilisateurServiceTest {
	@PersistenceContext(unitName = "punit")
	private EntityManager entityManager;
	@Autowired
	UtilisateurService utilisateurService;
	@Autowired
	UtilisateurDao utilisateurDao;
	@Autowired
	PersonService personService;

	@Test
	@DatabaseSetup("sampleData.xml")
	public void testFind() throws Exception {
		List<Person> personList = this.personService.find("hil");
		assertEquals(1, personList.size());
		assertEquals("Phillip", personList.get(0).getFirstName());
	}
}
