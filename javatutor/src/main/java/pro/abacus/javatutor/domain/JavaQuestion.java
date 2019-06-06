package pro.abacus.javatutor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**
 * A JavaQuestion entity class.
 */

@Document
public class JavaQuestion {
	@Id
	private String id;

	@JsonIgnore
	private User account;

	private String question;

	private String answer;

	public JavaQuestion() {
	}

	public JavaQuestion(User account, String question, String answer) {
		this.account = account;
		this.question = question;
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public User getAccount() {
		return account;
	}

	public void setAccount(User account) {
		this.account = account;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || (getClass() != obj.getClass()))
			return false;

		JavaQuestion question = (JavaQuestion) obj;
		if (getId() == null || question.getId() == null) {
			return Objects.equals(getId(), question.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "JavaQuestion [id=" + id + ", account=" + account + ", question=" + question + ", answer=" + answer
				+ "]";
	}

}
