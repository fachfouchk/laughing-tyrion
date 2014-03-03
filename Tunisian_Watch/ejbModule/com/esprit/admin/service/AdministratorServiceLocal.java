package com.esprit.admin.service;

import java.util.List;

import javax.ejb.Local;

import com.esprit.domain.Role;
import com.esprit.domain.User;

@Local
public interface AdministratorServiceLocal {
	
	public boolean AuthentificationAdmin(String a,String b) ;
	public void message();
	public User loginexist(String login);
	public boolean isValidEmailAddress(String email);
	public User showInformation(String login);
	public void addUser(String firstname, String lastname,String dateofbirth,String location,String login,String password,String mailbox,int phonenumber,Role role);	
    public void updateUser(String firstname, String lastname,String dateofbirth,String location,String login,String password,String mailbox,int phonenumber,Role role);
    public List<User> ListUser();
    public void deleteuser (int iddel);
    public boolean isvalidedateofbirth(String date);

}
