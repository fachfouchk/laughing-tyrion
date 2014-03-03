package com.esprit.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddCategoriePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static AddCategoriePage frame;
	Categories c;
	JList<Object> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCategoriePage f = new AddCategoriePage();
					f.setVisible(true);
					frame=f;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCategoriePage() {
		
		//ajout de description
		c=new Categories();
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Categorie :");
		lblNewLabel.setBounds(10, 11, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(20, 47, 120, 21);
		contentPane.add(lblDescription);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		contentPane.add(separator);
		
		textField = new JTextField();
		textField.setBounds(150, 47, 246, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				//c.getlistCategories();
				if(!textField.getText().toString().equals(""))
						{c.addCategorie(textField.getText().toString());
						JOptionPane.showMessageDialog(null, "category is added");
						}
				else 
					JOptionPane.showMessageDialog(null, "description is empty");
				
				
			}
		});
		btnAdd.setBounds(335, 228, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CategoriesManagmentPage cmp=new CategoriesManagmentPage();
				cmp.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(238, 228, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblClaim = new JLabel("Categories List :");
		lblClaim.setBounds(20, 90, 120, 51);
		contentPane.add(lblClaim);
		
		
		String []listData=new String[1000];
		int j=0;
		Iterator<String> i=c.getlistCategories().iterator();
		while(i.hasNext())
		{
			listData[j]=i.next().toString();
			System.out.println(listData[j]);
			j++;
		}

		
		list = new JList<Object>(listData);
		list.setBounds(150, 92, 246, 113);
	    contentPane.add(list);
		
	}
}
