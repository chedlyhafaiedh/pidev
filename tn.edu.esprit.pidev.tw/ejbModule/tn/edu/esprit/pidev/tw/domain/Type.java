package tn.edu.esprit.pidev.tw.domain;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Type
 *
 */
@Entity

public class Type implements Serializable {

	   
	
	private int id;
	private String predefinedType;
	private String other;
	private static final long serialVersionUID = 1L;

	public Type() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	
	public String getPredefinedType() {
		return this.predefinedType;
	}

	public void setPredefinedType(String predefinedType) {
		this.predefinedType = predefinedType;
	}   
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}
   
}
