package pro.abacus.javatutor;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void accessUnprotected() throws Exception {
		this.mockMvc.perform(get("/api/signup"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void accessProtectedApiRedirectsToLogin() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/api/javaquestions/"))
				.andExpect(status().is3xxRedirection())
				.andReturn();

		//assertThat(mvcResult.getResponse().getRedirectedUrl()).endsWith("/signin");
	}
	
	@Test
	public void loginUser() throws Exception {
		this.mockMvc.perform(formLogin("/api/signin").user("Tom").password("qwerty"))
				.andExpect(authenticated());
	}
		
	@Test
	public void loginInvalidUser() throws Exception {
		this.mockMvc.perform(formLogin("/api/signin").user("invalid").password("invalid"))
				.andExpect(unauthenticated())
				.andExpect(status().is3xxRedirection());
	}
	
	
	@Test
	@WithMockUser
	public void loginWithMockUser() throws Exception {
		this.mockMvc.perform(get("/api/javaquestions/"))
				.andExpect(authenticated());
	}

	


}
