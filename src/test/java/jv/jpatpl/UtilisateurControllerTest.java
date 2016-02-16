package jv.jpatpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jv.jpatpl.controller.TestController;

public class UtilisateurControllerTest extends WebAppContext {
	@Autowired
	TestController testController;

	@Test
	public void testLoadTestPage() throws Exception {
		this.mockMvc.perform(get("/rest/test/test")).andExpect(status().isOk());
	}
}
