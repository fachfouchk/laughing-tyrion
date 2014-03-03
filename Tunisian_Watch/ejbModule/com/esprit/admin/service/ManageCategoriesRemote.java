package com.esprit.admin.service;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.domain.Categorie;

@Remote
public interface ManageCategoriesRemote {

	public boolean addCatrgorie(Categorie categorie);
	public boolean deleteCatrgories(Categorie categorie);
	public List<String> getListCategories();
	public List<Categorie> getListAllCategories();
	public void deleteCatrgoriesById(int id);
	public void updateCategorie(int id, String description);
	public void testmessage();
	
}
