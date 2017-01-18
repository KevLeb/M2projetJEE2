package fr.beans;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.services.ConnectedUser;

@Entity()
@Stateful(name="connectedUserBean")
public class Person implements ConnectedUser {


	@Column(name = "firstName")
	@NotNull
	private String firstName;

	@Column(name = "lastName")
	@NotNull
	private String lastName;
	
	@Id()
	@Column(name = "email")
	@NotNull
	private String email;
	
	@Column(name = "web")
	private String web;
	
	@Column(name = "birthday")
	private String birthday;
	
	@NotNull
	@Size(min=6)
	@Column(name = "password")
	private String password;
	
	public Person(){
		
	}
	
	public void login(String login, String pwd){
		
	}
	
	@Remove
	public void logout(){
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
