package pro.abacus.javatutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityIntegrationDatabaseTest {
	private static final String SIGN_IN = "/api/signin";
	private static final String JAVA_QUESTIONS = "/api/javaquestions/";

	private static final String VALID_LOGIN = "Tom";
	private static final String VALID_PASSWORD = "qwerty";

	private static final String INVALID_LOGIN = "invalidLogin";
	private static final String INVALID_PASSWORD = "invalidPassword";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldAuthenticateUserWithValidCredentials() throws Exception {
		this.mockMvc.perform(formLogin(SIGN_IN).user(VALID_LOGIN).password(VALID_PASSWORD))
				.andExpect(authenticated());
	}

	@Test
	public void shouldAccessProtectedEndpoinAfterSuccessfulLogin() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(formLogin(SIGN_IN).user(VALID_LOGIN).password(VALID_PASSWORD))
				.andExpect(authenticated())
				.andReturn();

		MockHttpSession httpSession = MockHttpSession.class.cast(mvcResult.getRequest().getSession(false));

		this.mockMvc.perform(get(JAVA_QUESTIONS)
				.session(httpSession))
				.andExpect(status().isOk());
	}

	@Test
	public void shouldNotAuthenticateUserWithInvalidCredentials() throws Exception {
		this.mockMvc.perform(formLogin(SIGN_IN).user(INVALID_LOGIN).password(INVALID_PASSWORD))
				.andExpect(unauthenticated())
				.andExpect(status().is4xxClientError());
	}

}
