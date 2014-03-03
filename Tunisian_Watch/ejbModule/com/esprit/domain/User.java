package com.esprit.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.esprit.domain.Role;

@Entity
@Table(name="USER")
public class User implements Serializable{

	@Id
	@Column(name="IdUser")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;
	@Column(name="FirstName")
	private String firstname;
	@Column(name="LastName")
	private String lastname;
	@Column(name="MailBox")
	private String mailbox;
	@Column(name="Password")
	private String password;
	@Column(name="Location")
	private String location;
	@Column(name="DateOfBirth")
	private String dateofbirth;
	@Column(name="PhoneNumber")
	private int phonenumber;
	@Column(name="Login")
	private String login;
	
	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Claim> claims;
	
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}
	
	public User(int iduser, String firstname, String lastname, String mailbox,
			String password, String location, String dateofbirth,
			int phonenumber, String login, Role role, List<Claim> claims) {
		super();
		this.iduser = iduser;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mailbox = mailbox;
		this.password = password;
		this.location = location;
		this.dateofbirth = dateofbirth;
		this.phonenumber = phonenumber;
		this.login = login;
		this.role = role;
		this.claims = claims;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
