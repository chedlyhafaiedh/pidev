package domaine;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import services.UserServicesRemote;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements  Serializable {

	
	private int idUser;
	private String firstName;
	private String lastName;
	private String mailBox;
	private String passWord;
	private String login;
	private String phoneNumber;
	private String location;
	
	private String statut;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	@Id    
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}   
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getMailBox() {
		return this.mailBox;
	}

	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}   
	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(Object object) {
		this.statut = (String) object;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}   
	
   
}
