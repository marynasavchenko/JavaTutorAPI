package pro.abacus.javatutor.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pro.abacus.javatutor.services.JavaQuestionsService;

@RunWith(SpringRunner.class)
@WebMvcTest (QuestionRestController.class)
@AutoConfigureMockMvc(secure=false)
public class QuestionRestControllerTest {
	
	@MockBean
	private JavaQuestionsService javaQuestionsService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	private QuestionRestController questionRestController = new QuestionRestController(javaQuestionsService);
	
	@Test 
	public void shoudReadJavaQuestions () throws Exception {
		mockMvc.perform(get("/api/javaquestions"))
			.andExpect(status().isOk());
		
		verify(javaQuestionsService).findAllQuestions();
	}

}
