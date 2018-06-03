package pro.abacus.javatutor.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Authority {


    private String authority;
    
    public Authority(String authority) {
    	this.authority=authority;
    }

    public String getName() {
        return authority;
    }

    public void setName(String name) {
        this.authority = name;
    }

	@Override
	public String toString() {
		return "Authority [name=" + authority + "]";
	}
    
    
}
