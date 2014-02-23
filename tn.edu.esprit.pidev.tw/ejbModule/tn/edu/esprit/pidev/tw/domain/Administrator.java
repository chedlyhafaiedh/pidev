package tn.edu.esprit.pidev.tw.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Administrator
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Administrator extends Person implements Serializable {

	private String Role;
	private List<Claim> claims;
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

	public String getRole() {
		return this.Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}

	@OneToMany(mappedBy = "administrator")
	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

}
