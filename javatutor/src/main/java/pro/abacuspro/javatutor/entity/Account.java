package pro.abacuspro.javatutor.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	@OneToMany(mappedBy = "account")
    private Set<JavaQuestion> bookmarks = new HashSet<>();
	
	public Account() { } 

    public Account(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

}
