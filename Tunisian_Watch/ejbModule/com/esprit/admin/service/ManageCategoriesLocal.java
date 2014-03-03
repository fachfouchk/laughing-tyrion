package com.esprit.admin.service;

import java.util.List;

import javax.ejb.Local;

import com.esprit.domain.Categorie;

@Local
public interface ManageCategoriesLocal {
	
	public boolean addCatrgorie(Categorie categorie);
	public boolean deleteCatrgories(Categorie categorie);
	public List<String> getListCategories();
	public List<Categorie> getListAllCategories();
	public void deleteCatrgoriesById(int id);
	public void updateCategorie(int id, String description);
	public void testmessage();

}
