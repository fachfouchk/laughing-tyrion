package com.esprit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLAIM")
public class Claim {
	
	@Id
	@Column(name="IdClaim")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idclaim;
	@Column(name="Description")
	private String description;
	@Column(name="Location")
	private String location;
	@Column(name="Direction")
	private String direction;
	@Column(name="PersonnelInjury")
	private String personnelinjury;
	@Column(name="Evidence")
	private String evidence;
	@Column(name="Statut")
	private String statut;
	@Column(name="Priority")
	private String priority;
	@Column(name="Date")
	private String date;
	@Column(name="CloseDate")
	private String closedate;
	@Column(name="ShedulesDate")
	private String shedulesdate;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Categorie categorie;
	
	//@OneToMany(mappedBy="claim")
	//private java.util.List<Categorie> categories;

	public int getIdclaim() {
		return idclaim;
	}

	public void setIdclaim(int idclaim) {
		this.idclaim = idclaim;
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

	public String getPersonnelinjury() {
		return personnelinjury;
	}

	public void setPersonnelinjury(String personnelinjury) {
		this.personnelinjury = personnelinjury;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClosedate() {
		return closedate;
	}

	public void setClosedate(String closedate) {
		this.closedate = closedate;
	}

	public String getShedulesdate() {
		return shedulesdate;
	}

	public void setShedulesdate(String shedulesdate) {
		this.shedulesdate = shedulesdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Claim(int idclaim, String description, String location,
			String direction, String personnelinjury, String evidence,
			String statut, String priority, String date, String closedate,
			String shedulesdate, User user) {
		super();
		this.idclaim = idclaim;
		this.description = description;
		this.location = location;
		this.direction = direction;
		this.personnelinjury = personnelinjury;
		this.evidence = evidence;
		this.statut = statut;
		this.priority = priority;
		this.date = date;
		this.closedate = closedate;
		this.shedulesdate = shedulesdate;
		this.user = user;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
