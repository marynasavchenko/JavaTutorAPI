package pro.abacus.javatutor.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * A user.
 */
@Document
public class User {
	
	@Id
	@NotNull
	private String id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	private Set<Authority> authorities = new HashSet<>();
	
    private List<JavaQuestion> javaquestions = new ArrayList<>();
	
	public User() { } 

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities=authorities;
    }
    
    public User (User user) {
    	this.username = user.getUsername();
    	this.password=user.getPassword();
    	this.authorities=user.getUserAuthorities();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Authority> getUserAuthorities() {
		return authorities;
	}

	public void setUserAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	

	public List<JavaQuestion> getJavaquestions() {
		return javaquestions;
	}

	public void setJavaquestions(List<JavaQuestion> javaquestions) {
		this.javaquestions = javaquestions;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null || (getClass() != obj.getClass()))
			return false;

		User user = (User) obj;
		if (getId() == null || user.getId() == null) {
			return Objects.equals(getId(), user.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", authorities="
				+ authorities + ", javaquestions=" + javaquestions + "]";
	}

    
}
