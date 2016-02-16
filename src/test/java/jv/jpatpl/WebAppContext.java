package jv.jpatpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import jv.jpatpl.dao.UtilisateurDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/jpa-context.xml", "classpath:**/aop-context.xml", "classpath:**/dataSource-context.xml",
		"classpath:**/application-context.xml", "classpath:**/quartzByCode-context.xml" })
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class WebAppContext {

	protected MockMvc mockMvc;

	@Autowired
	WebApplicationContext wac;

	@Autowired
	UtilisateurDao utilisateurDao;

	@Before
	public void setup() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		// Setup Spring test in webapp-mode (same config as spring-boot)
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void isAlive() {
		Assert.notNull(utilisateurDao);
	}
}
