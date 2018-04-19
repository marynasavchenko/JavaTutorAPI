package pro.abacuspro.javatutor.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Document
@Data
public class JavaQuestion {
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonIgnore
	private Account account;
	
	private String question;
	
	private String answer;
	
	public JavaQuestion(){
		
	}

	public JavaQuestion(final Account account, final String question, final String answer) {
		super();
		this.account = account;
		this.question = question;
		this.answer = answer;
	}

}
