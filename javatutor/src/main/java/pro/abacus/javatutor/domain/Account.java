package pro.abacus.javatutor.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
@Data
public class Account {
	
	@Id
	private String id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
    private List<JavaQuestion> javaquestions = new ArrayList<>();
	
	public Account() { } 

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
