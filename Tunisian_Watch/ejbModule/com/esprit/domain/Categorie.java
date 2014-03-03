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
@Table(name="CATEGORIE")
public class Categorie implements Serializable{
	
	@Id
	@Column(name="IdCategorie")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcategorie;
	
	@Column(name="Description")
	private String description;
	
	@OneToMany(mappedBy="categorie")
	private List<Claim> claim;

	public int getIdcategorie() {
		return idcategorie;
	}

	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Claim> getClaim() {
		return claim;
	}

	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}

	public Categorie(int idcategorie, String description, List<Claim> claim) {
		super();
		this.idcategorie = idcategorie;
		this.description = description;
		this.claim = claim;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
