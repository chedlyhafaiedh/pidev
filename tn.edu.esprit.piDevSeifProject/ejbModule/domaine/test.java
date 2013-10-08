package domaine;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: test
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class test extends User implements Serializable {

	
	private String nom;
	private static final long serialVersionUID = 1L;

  
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
   
}
