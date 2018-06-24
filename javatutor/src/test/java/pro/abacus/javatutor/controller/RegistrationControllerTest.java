package pro.abacus.javatutor.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pro.abacus.javatutor.controller.RegistrationController;
import pro.abacus.javatutor.domain.User;
import pro.abacus.javatutor.services.UserService;


@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
@AutoConfigureMockMvc(secure = false)
public class RegistrationControllerTest {

	@MockBean
	private UserService userService;
	
	@MockBean
	private User user;
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private RegistrationController registrationController = new RegistrationController(userService);

	private static String userInJson(String name, String password) {
		return "{ \"name\": \"" + name + "\", " + 
				"\"password\":\"" + password + "\"}";
	}

	@Test
	public void shouldPostRegistrationDetails() throws Exception {

		mockMvc.perform(post("/api/signup")
				.contentType(MediaType.APPLICATION_JSON)
				.content(userInJson("user1", "1234567")))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldSaveUser() throws Exception {
		registrationController.registerUser(user);

		verify(userService).saveAccount(user);
	}

}
