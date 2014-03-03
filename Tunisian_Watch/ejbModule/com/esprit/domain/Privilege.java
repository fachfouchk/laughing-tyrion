package com.esprit.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRIVILEGE")
public class Privilege {
	
	@Id
	@Column(name="IdPrivilege")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idprivilege;
	@Column(name="PrivAddAdministrator")
	boolean privaddadministrator;
	@Column(name="PrivRemoveAdministrator")
	boolean privremoveadministrator;
	@Column(name="PrivLinkAdministratorToCategory")
	boolean privlinkadministratortocategory;
	@Column(name="PrivUpdateAdministrator")
	boolean privupdateadministrator;
	@Column(name="PrivInformAgent")
	boolean privinformagent;
	@Column(name="PrivLinkAgentToAuthority")
	boolean privlinkagenttoauthority;
	@Column(name="PrivCreateAccountCitizen")
	boolean privcreateaccountcitizen;
	@Column(name="PrivDesactivateAccountCitizen")
	boolean privdesactivateaccountcitizen;
	@Column(name="PrivUpdateAccountCitizen")
	boolean privupdateaccountcitizen;
	
	@OneToMany(mappedBy="privilege")
	private List<RolePrivilege> rolePrivileges;
	
	public Privilege(int idprivilege, boolean privaddadministrator,
			boolean privremoveadministrator,
			boolean privlinkadministratortocategory,
			boolean privupdateadministrator, boolean privinformagent,
			boolean privlinkagenttoauthority, boolean privcreateaccountcitizen,
			boolean privdesactivateaccountcitizen,
			boolean privupdateaccountcitizen, List<RolePrivilege> rolePrivileges) {
		super();
		this.idprivilege = idprivilege;
		this.privaddadministrator = privaddadministrator;
		this.privremoveadministrator = privremoveadministrator;
		this.privlinkadministratortocategory = privlinkadministratortocategory;
		this.privupdateadministrator = privupdateadministrator;
		this.privinformagent = privinformagent;
		this.privlinkagenttoauthority = privlinkagenttoauthority;
		this.privcreateaccountcitizen = privcreateaccountcitizen;
		this.privdesactivateaccountcitizen = privdesactivateaccountcitizen;
		this.privupdateaccountcitizen = privupdateaccountcitizen;
		this.rolePrivileges = rolePrivileges;
	}
	public List<RolePrivilege> getRolePrivileges() {
		return rolePrivileges;
	}
	public void setRolePrivileges(List<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}

	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdprivilege() {
		return idprivilege;
	}
	public void setIdprivilege(int idprivilege) {
		this.idprivilege = idprivilege;
	}
	public boolean isPrivaddadministrator() {
		return privaddadministrator;
	}
	public void setPrivaddadministrator(boolean privaddadministrator) {
		this.privaddadministrator = privaddadministrator;
	}
	public boolean isPrivremoveadministrator() {
		return privremoveadministrator;
	}
	public void setPrivremoveadministrator(boolean privremoveadministrator) {
		this.privremoveadministrator = privremoveadministrator;
	}
	public boolean isPrivlinkadministratortocategory() {
		return privlinkadministratortocategory;
	}
	public void setPrivlinkadministratortocategory(
			boolean privlinkadministratortocategory) {
		this.privlinkadministratortocategory = privlinkadministratortocategory;
	}
	public boolean isPrivupdateadministrator() {
		return privupdateadministrator;
	}
	public void setPrivupdateadministrator(boolean privupdateadministrator) {
		this.privupdateadministrator = privupdateadministrator;
	}
	public boolean isPrivinformagent() {
		return privinformagent;
	}
	public void setPrivinformagent(boolean privinformagent) {
		this.privinformagent = privinformagent;
	}
	public boolean isPrivlinkagenttoauthority() {
		return privlinkagenttoauthority;
	}
	public void setPrivlinkagenttoauthority(boolean privlinkagenttoauthority) {
		this.privlinkagenttoauthority = privlinkagenttoauthority;
	}
	public boolean isPrivcreateaccountcitizen() {
		return privcreateaccountcitizen;
	}
	public void setPrivcreateaccountcitizen(boolean privcreateaccountcitizen) {
		this.privcreateaccountcitizen = privcreateaccountcitizen;
	}
	public boolean isPrivdesactivateaccountcitizen() {
		return privdesactivateaccountcitizen;
	}
	public void setPrivdesactivateaccountcitizen(
			boolean privdesactivateaccountcitizen) {
		this.privdesactivateaccountcitizen = privdesactivateaccountcitizen;
	}
	public boolean isPrivupdateaccountcitizen() {
		return privupdateaccountcitizen;
	}
	public void setPrivupdateaccountcitizen(boolean privupdateaccountcitizen) {
		this.privupdateaccountcitizen = privupdateaccountcitizen;
	}
	

}
