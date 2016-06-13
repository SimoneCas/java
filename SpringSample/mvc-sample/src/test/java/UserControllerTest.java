import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mvcsample.controller.HomeController;
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
				new InternalResourceView("/WEB-INF/views/users.jsp"))
				.build();
		mockMvc.perform(get("/users"))
				.andExpect(view().name("users"))
				.andExpect(model().attributeExists("userList"))
				.andExpect(
						model().attribute("userListList",
								hasItems(expectedUsers.toArray())));
	}

	private List<User> createUserList() {
		List<User> users = new ArrayList<User>();

		users.add(new User("Mario", "Rossi", new Date()));
		users.add(new User("Federico", "Verdi", new Date()));
		users.add(new User("Mario", "Biondi", new Date()));

		return users;
	}
}
