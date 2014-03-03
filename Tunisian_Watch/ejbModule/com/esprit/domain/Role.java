package com.esprit.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="ROLE")
public class Role implements Serializable{
	
	@Id
	@Column(name="IdRole")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrole;
	@Column(name="RoleUser")
	private String roleuser;
	
	@OneToMany(mappedBy="role")
	private List<User> users;
	
	@OneToMany(mappedBy="role")
	private List<RolePrivilege> rolePrivileges ;

	public int getIdrole() {
		return idrole;
	}

	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}

	public String getRoleuser() {
		return roleuser;
	}

	public void setRoleuser(String roleuser) {
		this.roleuser = roleuser;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
