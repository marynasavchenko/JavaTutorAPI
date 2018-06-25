package pro.abacus.javatutor.domain;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * An authority (a security role) used by Spring Security.
 */
@Document
public class Authority {

	@Id
	@NotNull
	private String authorityName;

	public Authority(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null || (getClass() != obj.getClass()))
			return false;

		Authority authority = (Authority) obj;
		if (getAuthorityName() == null || authority.getAuthorityName() == null) {
			return Objects.equals(getAuthorityName(), authority.getAuthorityName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getAuthorityName());
	}

	@Override
	public String toString() {
		return "Authority [authorityName=" + authorityName + "]";
	}

}
