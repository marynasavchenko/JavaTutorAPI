package pro.abacus.javatutor.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest (QuestionRestController.class)
@AutoConfigureMockMvc(secure=false)
public class QuestionRestControllerTest {
	
	

}
