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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

	@Override
	public String toString() {
		return "Authority [authority=" + authority + "]";
	}
    
    
}
