package com.esprit.admin;

import java.awt.EventQueue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.esprit.admin.service.AdministratorServiceRemote;
import com.esprit.domain.Role;
import com.esprit.domain.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ManageUser extends JFrame {

	private JPanel contentPane;
	private JTextField firstnametxt;
	private JTextField lastnametxt;
	private JTextField dateofbirthtxt;
	private JTextField mailboxtxt;
	private JTextField phonenumbertxt;
	private JTextField logintxt;
	private JTextField passwordtxt;
	private JComboBox locationtxt;
	private JComboBox roletxt;
	private JTextField loginupdatetxt;
	private JTextField firstnameupdatetxt;
	private JTextField lastnameupdatetxt;
	private JTextField dateofbirthupdatetxt;
	private JTextField mailboxupdatetxt;
	private JTextField phonenumberupdate;
	private JTextField passwordupdatetxt;
	private JComboBox locationupdatetxt;
	private JComboBox roleupdatetxt;
	private JTable tablelist;
	private JScrollPane scrolllistuser;
	private JTable tabledelete;
	private JScrollPane scrollPaneDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUser frame = new ManageUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageUser() {
		setResizable(false);
		setTitle("User Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "User Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setToolTipText("Add User \r\n");
		tabbedPane.setBounds(10, 11, 494, 337);
		contentPane.add(tabbedPane);
		
		JPanel paneladduser = new JPanel();
		tabbedPane.addTab("Add User ", null, paneladduser, null);
		paneladduser.setLayout(null);
		
		JButton btnAddUser = new JButton("Add");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Context context;
				try {
					context = new InitialContext();
					AdministratorServiceRemote administratorService = (AdministratorServiceRemote) context.lookup("/Tunisian_Watch/AdministratorService!"+AdministratorServiceRemote.class.getCanonicalName());
					String firstname=firstnametxt.getText().toString();
					String lastname=lastnametxt.getText().toString();
					String dateofbirth=dateofbirthtxt.getText().toString();
					String location=locationtxt.getSelectedItem().toString();
					String login=logintxt.getText().toString();
					String password=passwordtxt.getText().toString();
					String mailbox=mailboxtxt.getText().toString();
					Role role=new Role();
					role.setIdrole(roletxt.getSelectedIndex());
					role.setRoleuser(roletxt.getSelectedItem().toString());					
					
					//data verification
					if(phonenumbertxt.getText().length()!=11)
					{
						JOptionPane.showMessageDialog(null,"Invalid Phone Number !");
					}
					else if(administratorService.isvalidedateofbirth(dateofbirth)==false)
					{
						JOptionPane.showMessageDialog(null,"Invalid Date !");
					}
				
					else if((firstname.length()==0)||(lastname.length()==0)||(dateofbirth.length()==0)||(mailbox.length()==0))
					{
						JOptionPane.showMessageDialog(null,"All Texfields must not be empty!");
					}
					else if(administratorService.isValidEmailAddress(mailbox)==false)
					{
						JOptionPane.showMessageDialog(null,"Email is not valid !");
					}
					else if ((login.length()<4)||(password.length()<4))
					{
						JOptionPane.showMessageDialog(null,"Login and Password must have at least 4 caracters !");
					}
					else if(administratorService.loginexist(login)!=null)
					{
						JOptionPane.showMessageDialog(null,"Login already exist !");
					}
					else
					{	
						int phonenumber=Integer.parseInt(phonenumbertxt.getText().toString().substring(3));
						administratorService.addUser(firstname, lastname, dateofbirth, location, login, password, mailbox, phonenumber, role);
						JOptionPane.showMessageDialog(null,"Data successfully added !");
					}	
					
					} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddUser.setBounds(378, 252, 89, 23);
		paneladduser.add(btnAddUser);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 11, 83, 14);
		paneladduser.add(lblFirstName);
		
		firstnametxt = new JTextField();
		firstnametxt.setBounds(97, 8, 86, 20);
		paneladduser.add(firstnametxt);
		firstnametxt.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 45, 83, 14);
		paneladduser.add(lblLastName);
		
		lastnametxt = new JTextField();
		lastnametxt.setBounds(97, 42, 86, 20);
		paneladduser.add(lastnametxt);
		lastnametxt.setColumns(10);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(10, 81, 83, 14);
		paneladduser.add(lblBirthDate);
		
		dateofbirthtxt = new JTextField();
		dateofbirthtxt.setBounds(97, 78, 86, 20);
		paneladduser.add(dateofbirthtxt);
		dateofbirthtxt.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(10, 120, 77, 14);
		paneladduser.add(lblLocation);
		
		locationtxt = new JComboBox();
		locationtxt.setModel(new DefaultComboBoxModel(new String[] {"Tunis", "Ben Arous", "Ariana", "El Kef", "Jandouba", "Mednine", "Tataouine", "Nabeul", "Bizerte", "Monastir", "Sousse", "Mahdia", "Gabes", "Gasserine", "Gafsa", "Mannouba", "Sfax", "Karouane", "Seliane", "Beja", "Sidi Bouzid", "Gbelli"}));
		locationtxt.setToolTipText("");
		locationtxt.setBounds(97, 117, 86, 20);
		paneladduser.add(locationtxt);
		
		
		JLabel lblNewLabel = new JLabel("Mail Box");
		lblNewLabel.setBounds(10, 160, 83, 14);
		paneladduser.add(lblNewLabel);
		
		mailboxtxt = new JTextField();
		mailboxtxt.setBounds(97, 157, 86, 20);
		paneladduser.add(mailboxtxt);
		mailboxtxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setBounds(10, 200, 83, 14);
		paneladduser.add(lblNewLabel_1);
		
		phonenumbertxt = new JTextField();
		phonenumbertxt.setText("216");
		phonenumbertxt.setBounds(97, 197, 86, 20);
		paneladduser.add(phonenumbertxt);
		phonenumbertxt.setColumns(12);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(271, 63, 57, 14);
		paneladduser.add(lblLogin);
		
		logintxt = new JTextField();
		logintxt.setBounds(338, 60, 113, 20);
		paneladduser.add(logintxt);
		logintxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(271, 100, 69, 14);
		paneladduser.add(lblPassword);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(338, 97, 113, 20);
		paneladduser.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(271, 142, 46, 14);
		paneladduser.add(lblRole);
		
		roletxt = new JComboBox();
		roletxt.setModel(new DefaultComboBoxModel(new String[] {"", "Administrator", "Agent", "Citizen"}));
		roletxt.setSelectedIndex(1);
		roletxt.setBounds(338, 139, 113, 20);
		paneladduser.add(roletxt);
		
		JPanel panelupdateuser = new JPanel();
		tabbedPane.addTab("Update User", null, panelupdateuser, null);
		panelupdateuser.setLayout(null);
		
		//update user
		
		JButton btnUpdateUser = new JButton("Update");
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Context context;
				try {
					context = new InitialContext();
					AdministratorServiceRemote administratorService = (AdministratorServiceRemote) context.lookup("/Tunisian_Watch/AdministratorService!"+AdministratorServiceRemote.class.getCanonicalName());

					String login=loginupdatetxt.getText().toString();
					String firstname=firstnameupdatetxt.getText().toString();
					String lastname=lastnameupdatetxt.getText().toString();
					String dateofbirth=dateofbirthupdatetxt.getText().toString();
					String location=locationupdatetxt.getSelectedItem().toString();
					String password=passwordupdatetxt.getText().toString();
					String mailbox=mailboxupdatetxt.getText().toString();
					int phonenumber=Integer.parseInt(phonenumberupdate.getText().toString());
					Role role=new Role();
					role.setIdrole(roleupdatetxt.getSelectedIndex());
					role.setRoleuser(roleupdatetxt.getSelectedItem().toString());
					
					//data verification
					//if(phonenumbertxt.getText().length()!=8)
					//{
					//	JOptionPane.showMessageDialog(null,"Invalid Phone Number !");
					//}
					/*else*/ if((firstname.length()==0)||(lastname.length()==0)||(dateofbirth.length()==0)||(mailbox.length()==0))
					{
						JOptionPane.showMessageDialog(null,"All Texfields must not be empty!");
					}
					else if(administratorService.isValidEmailAddress(mailbox)==false)
					{
						JOptionPane.showMessageDialog(null,"Email is not valid !");
					}
					else if ((login.length()<4)||(password.length()<4))
					{
						JOptionPane.showMessageDialog(null,"Login and Password must have at least 4 caracters !");
					}
					else
					{	
						administratorService.updateUser(firstname, lastname, dateofbirth, location, login, password, mailbox, phonenumber, role);
						JOptionPane.showMessageDialog(null,"Data successfully updated !");
					}
					
					
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnUpdateUser.setBounds(378, 252, 89, 23);
		panelupdateuser.add(btnUpdateUser);
		
		loginupdatetxt = new JTextField();
		loginupdatetxt.setBounds(196, 11, 86, 20);
		panelupdateuser.add(loginupdatetxt);
		loginupdatetxt.setColumns(10);
		
		JLabel lblEnterLoginOf = new JLabel("Enter login of the user to update");
		lblEnterLoginOf.setBounds(10, 14, 176, 14);
		panelupdateuser.add(lblEnterLoginOf);
		
		//show user information action 
		JButton btnShowInformationUser = new JButton("Show Information");
		btnShowInformationUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Context context;
				try {
					context = new InitialContext();
					AdministratorServiceRemote administratorService = (AdministratorServiceRemote) context.lookup("/Tunisian_Watch/AdministratorService!"+AdministratorServiceRemote.class.getCanonicalName());

					String login=loginupdatetxt.getText().toString();
					
					if(administratorService.loginexist(login)==null)
					{
						JOptionPane.showMessageDialog(null,"Login does not exist !");
					}
					else
					{
					passwordupdatetxt.setText(administratorService.showInformation(login).getPassword().toString());
					firstnameupdatetxt.setText(administratorService.showInformation(login).getFirstname().toString());
					lastnameupdatetxt.setText(administratorService.showInformation(login).getLastname().toString());
					dateofbirthupdatetxt.setText(administratorService.showInformation(login).getDateofbirth().toString());
					mailboxupdatetxt.setText(administratorService.showInformation(login).getMailbox().toString());
					locationupdatetxt.setSelectedItem(administratorService.showInformation(login).getLocation().toString());
					roleupdatetxt.setSelectedIndex(administratorService.showInformation(login).getRole().getIdrole());
					phonenumberupdate.setText(Integer.toString(administratorService.showInformation(login).getPhonenumber()));
					}
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnShowInformationUser.setBounds(322, 10, 145, 23);
		panelupdateuser.add(btnShowInformationUser);
		
		JLabel lblFirstName_1 = new JLabel("First Name");
		lblFirstName_1.setBounds(10, 107, 89, 14);
		panelupdateuser.add(lblFirstName_1);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setBounds(10, 143, 65, 14);
		panelupdateuser.add(lblLastName_1);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(10, 180, 89, 14);
		panelupdateuser.add(lblDateOfBirth);
		
		JLabel lblLocation_1 = new JLabel("Location ");
		lblLocation_1.setBounds(10, 217, 65, 14);
		panelupdateuser.add(lblLocation_1);
		
		JLabel lblMailBox = new JLabel("Mail Box");
		lblMailBox.setBounds(255, 107, 65, 14);
		panelupdateuser.add(lblMailBox);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(255, 143, 46, 14);
		panelupdateuser.add(lblPhone);
		
		JLabel lblRole_1 = new JLabel("Role");
		lblRole_1.setBounds(255, 180, 46, 14);
		panelupdateuser.add(lblRole_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(122, 54, 46, 14);
		panelupdateuser.add(lblPassword_1);
		
		firstnameupdatetxt = new JTextField();
		firstnameupdatetxt.setBounds(100, 104, 86, 20);
		panelupdateuser.add(firstnameupdatetxt);
		firstnameupdatetxt.setColumns(10);
		
		lastnameupdatetxt = new JTextField();
		lastnameupdatetxt.setBounds(100, 140, 86, 20);
		panelupdateuser.add(lastnameupdatetxt);
		lastnameupdatetxt.setColumns(10);
		
		dateofbirthupdatetxt = new JTextField();
		dateofbirthupdatetxt.setBounds(100, 177, 86, 20);
		panelupdateuser.add(dateofbirthupdatetxt);
		dateofbirthupdatetxt.setColumns(10);
		
		mailboxupdatetxt = new JTextField();
		mailboxupdatetxt.setBounds(322, 104, 119, 20);
		panelupdateuser.add(mailboxupdatetxt);
		mailboxupdatetxt.setColumns(10);
		
		phonenumberupdate = new JTextField();
		phonenumberupdate.setBounds(322, 140, 119, 20);
		panelupdateuser.add(phonenumberupdate);
		phonenumberupdate.setColumns(10);
		
		locationupdatetxt = new JComboBox();
		locationupdatetxt.setModel(new DefaultComboBoxModel(new String[] {"Tunis", "Ben Arous", "Ariana", "El Kef", "Jandouba", "Mednine", "Tataouine", "Nabeul", "Bizerte", "Monastir", "Sousse", "Mahdia", "Gabes", "Gasserine", "Gafsa", "Mannouba", "Sfax", "Karouane", "Seliane", "Beja", "Sidi Bouzid", "Gbelli"}));
		locationupdatetxt.setToolTipText("");
		locationupdatetxt.setBounds(100, 214, 86, 20);
		panelupdateuser.add(locationupdatetxt);
		
		roleupdatetxt = new JComboBox();
		roleupdatetxt.setModel(new DefaultComboBoxModel(new String[] {"", "Administrator", "Agent", "Citizen"}));
		roleupdatetxt.setBounds(322, 177, 119, 20);
		panelupdateuser.add(roleupdatetxt);
		
		passwordupdatetxt = new JTextField();
		passwordupdatetxt.setBounds(196, 51, 86, 20);
		panelupdateuser.add(passwordupdatetxt);
		passwordupdatetxt.setColumns(10);
		
		JPanel paneldeleteuser = new JPanel();
		paneldeleteuser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Context context;
				try {
					context = new InitialContext();
					AdministratorServiceRemote administratorService = (AdministratorServiceRemote) context.lookup("/Tunisian_Watch/AdministratorService!"+AdministratorServiceRemote.class.getCanonicalName());

				
					List<User> listuser=administratorService.ListUser();
					String [] titres = {"Id", "First Name", "Last Name", "Date of Birth","Location","Login","Password","Mail Box","Phone Number"};
					int taille = listuser.size();
					 Object [][] valeurs = new Object[taille][9];
     		        
     		        for(int i= 0; i < taille; i++)
     		        {    	
     		                 valeurs[i][0]=listuser.get(i).getIduser();
     		                valeurs[i][1]=listuser.get(i).getFirstname();
     		               valeurs[i][2]=listuser.get(i).getLastname();
     		              valeurs[i][3]=listuser.get(i).getDateofbirth();
     		             valeurs[i][4]=listuser.get(i).getLocation();
     		            valeurs[i][5]=listuser.get(i).getLogin();
     		           valeurs[i][6]=listuser.get(i).getPassword();
     		          valeurs[i][7]=listuser.get(i).getMailbox();
     		         valeurs[i][8]=listuser.get(i).getPhonenumber();     
     		        }
     		       DefaultTableModel dtmd = new DefaultTableModel(valeurs,titres);
     		       tabledelete.setModel(dtmd);
     		       scrollPaneDelete.setViewportView(tabledelete);
     		       

				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		paneldeleteuser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				Context context;
				try {
					context = new InitialContext();
					AdministratorServiceRemote administratorService = (AdministratorServiceRemote) context.lookup("/Tunisian_Watch/AdministratorService!"+AdministratorServiceRemote.class.getCanonicalName());

					List<User> listuser=administratorService.ListUser();
					String [] titres = {"Id", "First Name", "Last Name", "Date of Birth","Location","Login","Password","Mail Box","Phone Number"};
					int taille = listuser.size();
					 Object [][] valeurs = new Object[taille][9];
     		        
     		        for(int i= 0; i < taille; i++)
     		        {    	
     		                 valeurs[i][0]=listuser.get(i).getIduser();
     		                valeurs[i][1]=listuser.get(i).getFirstname();
     		               valeurs[i][2]=listuser.get(i).getLastname();
     		              valeurs[i][3]=listuser.get(i).getDateofbirth();
     		             valeurs[i][4]=listuser.get(i).getLocation();
     		            valeurs[i][5]=listuser.get(i).getLogin();
     		           valeurs[i][6]=listuser.get(i).getPassword();
     		          valeurs[i][7]=listuser.get(i).getMailbox();
     		         valeurs[i][8]=listuser.get(i).getPhonenumber();     
     		        }
     		       DefaultTableModel dtmd = new DefaultTableModel(valeurs,titres);
     		       tabledelete.setModel(dtmd);
     		       scrollPaneDelete.setViewportView(tabledelete);
     		       

				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		tabbedPane.addTab("Delete User", null, paneldeleteuser, null);
		paneldeleteuser.setLayout(null);
		
		tabledelete = new JTable();
		tabledelete.setBounds(10, 11, 457, 203);
		paneldeleteuser.add(tabledelete);
		
		//delete user
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Context context;
				try {
					context = new InitialContext();
					AdministratorServiceRemote administratorService = (AdministratorServiceRemote) context.lookup("/Tunisian_Watch/AdministratorService!"+AdministratorServiceRemote.class.getCanonicalName());
					int iddel = Integer.parseInt(tabledelete.getValueAt(tabledelete.getSelectedRow(), tabledelete.getSelectedColumn()).toString());
					administratorService.deleteuser(iddel);
					
					JOptionPane.showMessageDialog(null,"User deleted successfully");
					
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btndelete.setBounds(378, 252, 89, 23);
		paneldeleteuser.add(btndelete);
		
		scrollPaneDelete = new JScrollPane();
		scrollPaneDelete.setBounds(10, 11, 457, 203);
		paneldeleteuser.add(scrollPaneDelete);
		
		JPanel panellistuser = new JPanel();
		tabbedPane.addTab("List Users", null, panellistuser, null);
		panellistuser.setLayout(null);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Context context;
				try {
					context = new InitialContext();
					AdministratorServiceRemote administratorService = (AdministratorServiceRemote) context.lookup("/Tunisian_Watch/AdministratorService!"+AdministratorServiceRemote.class.getCanonicalName());

					List<User> listuser=administratorService.ListUser();
					String [] titres = {"Id", "First Name", "Last Name", "Date of Birth","Location","Login","Password","Mail Box","Phone Number"};
					int taille = listuser.size();
					 Object [][] valeurs = new Object[taille][9];
     		        
     		        for(int i= 0; i < taille; i++)
     		        {    	
     		                 valeurs[i][0]=listuser.get(i).getIduser();
     		                valeurs[i][1]=listuser.get(i).getFirstname();
     		               valeurs[i][2]=listuser.get(i).getLastname();
     		              valeurs[i][3]=listuser.get(i).getDateofbirth();
     		             valeurs[i][4]=listuser.get(i).getLocation();
     		            valeurs[i][5]=listuser.get(i).getLogin();
     		           valeurs[i][6]=listuser.get(i).getPassword();
     		          valeurs[i][7]=listuser.get(i).getMailbox();
     		         valeurs[i][8]=listuser.get(i).getPhonenumber();     
     		        }
     		       DefaultTableModel dtm = new DefaultTableModel(valeurs,titres);
     		       tablelist.setModel(dtm);
     		       scrolllistuser.setViewportView(tablelist);
     		       

				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnRefresh.setBounds(378, 252, 89, 23);
		panellistuser.add(btnRefresh);
		
		tablelist = new JTable();
		tablelist.setBounds(33, 32, 388, 104);
		panellistuser.add(tablelist);
		
		scrolllistuser = new JScrollPane();
		scrolllistuser.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrolllistuser.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrolllistuser.setBounds(10, 11, 457, 230);
		panellistuser.add(scrolllistuser);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPage ap=new AdminPage();
				ap.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(398, 359, 89, 23);
		contentPane.add(btnBack);
	}
}
