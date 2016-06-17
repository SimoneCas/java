import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mvcsample.controller.HomeController;
import mvcsample.controller.UserController;
import mvcsample.model.User;
import mvcsample.repository.UserRepository;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

public class UserControllerTest {

	@Test
	public void shouldShowRecentUsers() throws Exception {

		List<User> expectedUsers = createUserList();
		UserRepository mockRepository = mock(UserRepository.class);
		when(mockRepository.findUsers(Long.MAX_VALUE, 3)).thenReturn(
				expectedUsers);
		UserController controller = new UserController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).setSingleView(
				new InternalResourceView("/WEB-INF/views/users.jsp")).build();
		mockMvc.perform(get("/users?count=3"))
				.andExpect(view().name("users"))
				.andExpect(model().attributeExists("userList"))
				.andExpect(
						model().attribute("userList",
								hasItems(expectedUsers.toArray())));
	}

	@Test
	public void shouldShowUserByName() throws Exception {
		User expectedUser = new User("Claudio", "Rossi", new Date());
		UserRepository mockRepository = mock(UserRepository.class);
		when(mockRepository.findOneByName("Claudio")).thenReturn(expectedUser);
		UserController controller = new UserController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/users/Claudio")).andExpect(view().name("user"))
				.andExpect(model().attributeExists("user"))
				.andExpect(model().attribute("user", expectedUser));
	}

	@Test
	public void shouldShowRegistration() throws Exception {
		UserController controller = new UserController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/users/register")).andExpect(
				view().name("registerForm"));
	}

	@Test
	public void shouldProcessRegistration() throws Exception {
		UserRepository mockRepository = mock(UserRepository.class);
		User unsaved = new User("Fabio", "Itti", new Date());
		User saved = new User(24L, "Fabio", "Itti", new Date());
		when(mockRepository.save(unsaved)).thenReturn(saved);
		UserController controller = new UserController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(
				post("/users/register").param("name", "Fabio").param(
						"surname", "Itti")).andExpect(
				redirectedUrl("/users/Fabio"));
		//verify(mockRepository, atLeastOnce()).save(unsaved);
	}

	private List<User> createUserList() {
		List<User> users = new ArrayList<User>();

		users.add(new User("Mario", "Rossi", new Date()));
		users.add(new User("Federico", "Verdi", new Date()));
		users.add(new User("Mario", "Biondi", new Date()));

		return users;
	}
}
