package com.esprit.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAuth extends JFrame {

	private JPanel contentPane;
	private JTextField usrname;
	private JTextField psswrd;
	static AdminAuth adminauth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAuth frame = new AdminAuth();
					frame.setVisible(true);
					adminauth=frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminAuth() {
		setResizable(false);
		setTitle("AdminAuth");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("User Name :");
		lblLogin.setBounds(10, 15, 69, 14);
		contentPane.add(lblLogin);
		
		usrname = new JTextField();
		usrname.setBounds(89, 12, 103, 20);
		contentPane.add(usrname);
		usrname.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(202, 15, 69, 14);
		contentPane.add(lblPassword);
		
		psswrd = new JTextField();
		psswrd.setBounds(286, 12, 103, 20);
		contentPane.add(psswrd);
		psswrd.setColumns(10);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Admin ad=new Admin(usrname.getText(),psswrd.getText());
				ad.checkAuthentification(adminauth);
				
			}
		});
		button.setBounds(399, 11, 85, 23);
		contentPane.add(button);
	}
}
