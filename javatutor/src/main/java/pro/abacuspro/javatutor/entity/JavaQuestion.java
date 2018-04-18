package pro.abacuspro.javatutor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class JavaQuestion {
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonIgnore
    @ManyToOne
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
