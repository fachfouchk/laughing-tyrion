package com.esprit.admin.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.esprit.domain.Categorie;

@Stateless
public class ManageCategories implements ManageCategoriesLocal,ManageCategoriesRemote 
{
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean addCatrgorie(Categorie categorie) {
		 
		  em.persist(categorie);
		return false;
	}

	@Override
	public boolean deleteCatrgories(Categorie categorie) {
		em.remove(categorie);
		return false;
	}
	
	@Override
	public void deleteCatrgoriesById(int id) {
		Categorie u =(Categorie)em.createQuery("select e from Categorie e where e.idcategorie=:l").setParameter("l", id).getSingleResult();
    	em.remove(u);
	}
    
	@Override
	public void updateCategorie(int id, String description)
    {
    	Categorie c = (Categorie) em.createQuery("select e from Categorie e where e.idcategorie=:l").setParameter("l", id).getSingleResult();
    	c.setIdcategorie(id); 	
    	c.setDescription(description);
    	em.flush();
    
    }
	
	public List<String> getListCategories()
	{
		List<String> lg =(List<String>) em.createQuery("SELECT e.description FROM Categorie e").getResultList();
	    return lg;
    	
	}
	
	public List<Categorie> getListAllCategories()
	{
		List<Categorie> lg =(List<Categorie>)em.createQuery("SELECT e FROM Categorie e",Categorie.class).getResultList();
	    return lg;
    	
	}

	@Override
	public void testmessage() {
		System.out.println("tenja7 categorie");
		
	}



}
