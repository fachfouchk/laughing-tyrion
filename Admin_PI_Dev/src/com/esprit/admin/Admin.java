package com.esprit.admin;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.esprit.admin.service.AdministratorServiceRemote;

public class Admin {
	
	AdministratorServiceRemote as;
	private String login;
	private String mdp;
	
	public Admin(String login,String mdp) 
	{
		this.login=login;
		this.mdp=mdp;
		try {
			Context context = new InitialContext();			
			as =(AdministratorServiceRemote) context.lookup("/Tunisian_Watch/AdministratorService!"+AdministratorServiceRemote.class.getCanonicalName());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void checkAuthentification(AdminAuth adminauth)
	{
		if(as.AuthentificationAdmin(login, mdp))
			{AdminPage frame = new AdminPage();
			frame.setVisible(true);
			adminauth.setVisible(false);
			}
		else
		{
			JOptionPane.showMessageDialog(null, "Login Or Password Is invalid ... please try Again !!");
		}
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	

}
