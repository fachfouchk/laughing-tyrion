package com.esprit.admin.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.Stateless;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.esprit.domain.Role;
import com.esprit.domain.User;

/**
 * Session Bean implementation class AdministratorService
 */
@Stateless
public class AdministratorService implements AdministratorServiceRemote, AdministratorServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public AdministratorService() {
    }
    
    public boolean AuthentificationAdmin(String login,String mdp)
    {
    	if(login.equals("") && mdp.equals(""))
    		return false;
    	
    	try{
    		
    	User user=(User) em.createQuery("SELECT u FROM User u WHERE u.login=:p1 AND u.password=:p2").setParameter("p1", login).setParameter("p2", mdp).getSingleResult();
    	Role role =user.getRole();
    	if (role.getIdrole()==1) 
    		{return true;} 
    	else {
    		return false;
    	}
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    	
    }
    
    public void message()
    {
    	System.out.println("nej7a");
    }
  //email verification:
    public boolean isValidEmailAddress(String mailbox) 
    {
    	   boolean result = true;
    	   try {
    	      InternetAddress emailAddr = new InternetAddress(mailbox);
    	      emailAddr.validate();
    	   } catch (AddressException ex) {
    	      result = false;
    	   }
    	   return result;
    	}
    
    //login verification :
  public User loginexist(String login)
  {
	  try{
	  User u =(User) em.createQuery("select e from User e where e.login=:l").setParameter("l", login).getSingleResult();
	  return u;
	  }catch(Exception e){}
	return null;
	  
	  
  }
    //add user 
    public void addUser(String firstname, String lastname,String dateofbirth,String location,String login,String password,String mailbox,int phonenumber,Role role)
    {
    User u= new User();
    u.setFirstname(firstname);
    u.setLastname(lastname);
    u.setDateofbirth(dateofbirth);
    u.setLocation(location);
    u.setLogin(login);
    u.setPassword(password);
    u.setMailbox(mailbox);
    u.setPhonenumber(phonenumber);
    u.setRole(role);
    this.em.persist(u);
    }
    
    //show user information 
    public User showInformation(String login)
    {
    	User u =(User) em.createQuery("select e from User e where e.login=:l").setParameter("l", login).getSingleResult();
    	return u;
    }
    
    //update user 
    public void updateUser(String firstname, String lastname,String dateofbirth,String location,String login,String password,String mailbox,int phonenumber,Role role)
    {
    	User u = (User) em.createQuery("select e from User e where e.login=:l").setParameter("l", login).getSingleResult();
    	 	u.setFirstname(firstname);
    	    u.setLastname(lastname);
    	    u.setDateofbirth(dateofbirth);
    	    u.setLocation(location);
    	    u.setLogin(login);
    	    u.setPassword(password);
    	    u.setMailbox(mailbox);
    	    u.setPhonenumber(phonenumber);
    	    u.setRole(role);
    	    em.flush();
    
    }
    //list users
    
    public List<User> ListUser()
    {
    	
    	List<User> ResultList = em.createQuery("select e from User e", User.class).getResultList();
    	return ResultList;
    }
    
    public void deleteuser (int iddel)
    {
    	User u =(User) em.createQuery("select e from User e where e.iduser=:l").setParameter("l", iddel).getSingleResult();
    	em.remove(u);
    	
    }
    
    //date verification
    public boolean isvalidedateofbirth(String date)
    {
    	SimpleDateFormat df = new SimpleDateFormat("DD/MM/YYYY");
    	 try {
    	 	df.parse(date);
    	 	return true;
    	}
    	catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return false;
    }
    
   
}
