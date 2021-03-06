import static org.junit.Assert.assertEquals;
import mvcsample.controller.HomeController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;

public class HomeControllerTest {

	/*
	 * Questo metodo unitario valida solo il comportamento POJO del metodo
	 * richiamato ma non testa quali richieste vengono intercettate
	 * dall'HomeController
	 */
	@Test
	public void testHomePageBasic() throws Exception {
		HomeController controller = new HomeController();
		assertEquals("home", controller.home());
	}

	@Test
	public void testHomePage() throws Exception {
		HomeController controller = new HomeController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}
}

