package pro.abacus.javatutor.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Document
@Data
public class JavaQuestion {
	@Id
	private String id;
	
	@JsonIgnore
	private User account;
	
	private String question;
	
	private String answer;
	
	public JavaQuestion(){ }

	public JavaQuestion(User account, String question, String answer) {
		this.account = account;
		this.question = question;
		this.answer = answer;
	}

}
