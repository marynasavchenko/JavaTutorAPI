package pro.abacuspro.javatutor.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
@Data
public class Account {
	
	@Id
	@GeneratedValue
	private String id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	@OneToMany
    private List<JavaQuestion> javaquestions = new ArrayList<>();
	
	public Account() { } 

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
