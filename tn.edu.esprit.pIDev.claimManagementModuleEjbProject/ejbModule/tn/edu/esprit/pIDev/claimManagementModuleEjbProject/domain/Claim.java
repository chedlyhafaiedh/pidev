package tn.edu.esprit.pIDev.claimManagementModuleEjbProject.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Claim
 * 
 */
@Entity
public class Claim implements Serializable {

	private int idClaim;
	private String description;
	private String location;
	private String direction;
	private boolean personalInjury;

	private boolean visibility;
	private String statu;
	private int ptiority;
	private java.util.Date creationDate;
	private java.util.Date sheduledDate;
	private java.util.Date closedDate;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdClaim() {
		return idClaim;
	}

	public void setIdClaim(int idClaim) {
		this.idClaim = idClaim;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public boolean isPersonalInjury() {
		return personalInjury;
	}

	public void setPersonalInjury(boolean personalInjury) {
		this.personalInjury = personalInjury;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public int getPtiority() {
		return ptiority;
	}

	public void setPtiority(int ptiority) {
		this.ptiority = ptiority;
	}

	@Temporal(TemporalType.DATE)
	public java.util.Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.DATE)
	public java.util.Date getSheduledDate() {
		return sheduledDate;
	}

	public void setSheduledDate(java.util.Date sheduledDate) {
		this.sheduledDate = sheduledDate;
	}

	@Temporal(TemporalType.DATE)
	public java.util.Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(java.util.Date closedDate) {
		this.closedDate = closedDate;
	}

	//private static final long serialVersionUID = 1L;

	public Claim() {
		super();
	}

	public Claim(String description, String location, String direction,
			boolean personalInjury, boolean visibility, String statu,
			int ptiority, Date creationDate, Date sheduledDate, Date closedDate) {
		super();
		this.description = description;
		this.location = location;
		this.direction = direction;
		this.personalInjury = personalInjury;

		this.visibility = visibility;
		this.statu = statu;
		this.ptiority = ptiority;
		this.creationDate = creationDate;
		this.sheduledDate = sheduledDate;
		this.closedDate = closedDate;
	}
	public String toString(){
		return "claim"+this.getIdClaim()+"  description:"+this.getDescription()+
				"   statu:"+this.getStatu()+"   dateCreation:"+this.getCreationDate()
				+"   dateSheduled:"+this.getSheduledDate()+"   closedDate:"+this.getClosedDate();
		}

}
