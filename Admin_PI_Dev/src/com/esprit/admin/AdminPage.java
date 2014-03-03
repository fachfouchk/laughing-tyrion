package com.esprit.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	static AdminPage frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminPage();
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
	public AdminPage() {
		setResizable(false);
		setTitle("Administration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome ");
		lblNewLabel.setBounds(5, 5, 433, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnManageCategories = new JButton("Manage Categories");
		btnManageCategories.setBounds(79, 200, 300, 23);
		btnManageCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CategoriesManagmentPage cmp=new CategoriesManagmentPage();
				cmp.setVisible(true);
				frame.setVisible(false);
			}
		});
		contentPane.add(btnManageCategories);
		
		JButton btnManageUsers = new JButton("Manage Users");
		btnManageUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManageUser mu=new ManageUser();
				mu.setVisible(true);
				setVisible(false);
			}
		});
		btnManageUsers.setBounds(79, 148, 301, 23);
		contentPane.add(btnManageUsers);
	}
}
