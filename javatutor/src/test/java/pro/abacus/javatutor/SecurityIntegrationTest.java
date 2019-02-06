package pro.abacus.javatutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityIntegrationTest {

	private static final String JAVA_QUESTIONS = "/api/javaquestions/";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldRedirectToLoginWhenAccessProtectedEndpoint() throws Exception {
		this.mockMvc.perform(get(JAVA_QUESTIONS))
				.andExpect(status().is3xxRedirection());
	}

	@Test
	@WithMockUser
	public void shouldAuthenticateMockUser() throws Exception {
		this.mockMvc.perform(get(JAVA_QUESTIONS))
				.andExpect(authenticated());
	}

}
