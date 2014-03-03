package com.esprit.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoriesManagmentPage extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoriesManagmentPage f = new CategoriesManagmentPage();
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CategoriesManagmentPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddCategorie = new JButton("Add Categorie");
		btnAddCategorie.setBounds(118, 120, 315, 23);
		btnAddCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				AddCategoriePage frameAddCategorie= new AddCategoriePage();
				frameAddCategorie.setVisible(true);
				setVisible(false);
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddCategorie);
		
		JButton btnNewButton = new JButton("Remove Categorie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RemoveCategoriePage rcp=new RemoveCategoriePage();
				rcp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(118, 188, 316, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update Categorie");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateCategoriePage ucp=new UpdateCategoriePage();
				ucp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(118, 154, 315, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPage ap=new AdminPage();
				ap.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(229, 267, 95, 23);
		contentPane.add(btnBack);
	}

}
