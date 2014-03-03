package com.esprit.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class RolePrivilege {
	
	
	@ManyToOne
	@JoinColumn(name="IdRolePK",referencedColumnName="IdRole",insertable=false,updatable=false)
	private Role role;
	@ManyToOne
	@JoinColumn(name="IdPrivilegePK",referencedColumnName="IdPrivilege",insertable=false,updatable=false)
	private Privilege privilege;
	
	@EmbeddedId
	private RolePrivilegePK rolePrivilegePK;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public RolePrivilegePK getRolePrivilegePK() {
		return rolePrivilegePK;
	}

	public void setRolePrivilegePK(RolePrivilegePK rolePrivilegePK) {
		this.rolePrivilegePK = rolePrivilegePK;
	}

	public RolePrivilege(Role role, Privilege privilege,
			RolePrivilegePK rolePrivilegePK) {
		super();
		this.role = role;
		this.privilege = privilege;
		this.rolePrivilegePK = rolePrivilegePK;
	}

	public RolePrivilege() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	

}
