package com.esprit.admin;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.esprit.admin.service.ManageCategoriesRemote;
import com.esprit.domain.Categorie;

public class Categories {

	ManageCategoriesRemote mc;
	
	public Categories() {
		
		try {
			Context context = new InitialContext();			
			mc=(ManageCategoriesRemote) context.lookup("Tunisian_Watch/ManageCategories!"+ManageCategoriesRemote.class.getCanonicalName());
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	
	public boolean addCategorie(String descriptiontext)
	{
		Categorie categorie = new Categorie();
		categorie.setDescription(descriptiontext);
		//categorie.setClaim(claim);
		mc.addCatrgorie(categorie);
		return false;
	}
	
	public List<String> getlistCategories()
	{
		return(mc.getListCategories());
		
	}
	
	public List<Categorie> getlistAllCategories()
	{
		return(mc.getListAllCategories());
		
	}
	
	public void updateCategorie(int id,String desc)
	{
		mc.updateCategorie(id, desc);
		
	}
	
	public void DeleteSelectedCategorieById(int id)
	{
		mc.deleteCatrgoriesById(id);
		
	}
	
	
	
	
	

}
