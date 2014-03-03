package com.esprit.admin;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.esprit.domain.Categorie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateCategoriePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static UpdateCategoriePage frame;
	Categories c;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCategoriePage f = new UpdateCategoriePage();
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
	public UpdateCategoriePage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ID = Integer.parseInt(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString());
				System.out.println(ID);
				c=new Categories();
				c.updateCategorie(ID, textField.getText().toString());
				JOptionPane.showMessageDialog(null,"Categorie updated successfully");
			}
		});
		btnUpdate.setBounds(345, 238, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriesManagmentPage cmp=new CategoriesManagmentPage();
				cmp.setVisible(true);
				setVisible(false);
				
			}
		});
		btnBack.setBounds(246, 238, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblUpdateCategories = new JLabel("Update Categories :");
		lblUpdateCategories.setBounds(10, 11, 424, 23);
		contentPane.add(lblUpdateCategories);
		
		c=new Categories();
		List<Categorie> listCatego=c.getlistAllCategories();
		String [] titres = {"Id", "Description"};
		int taille = listCatego.size();
		Object [][] valeurs = new Object[taille][2];
		 for(int i= 0; i < taille; i++)
	        {    	
	                 valeurs[i][0]=listCatego.get(i).getIdcategorie();
	                valeurs[i][1]=listCatego.get(i).getDescription();
	        }
		 
		 DefaultTableModel dtmd = new DefaultTableModel(valeurs,titres);
		 table = new JTable(dtmd);
		 table.setBounds(20, 36, 402, 191);
		   contentPane.add(table);
	       JScrollPane scrollPane = new JScrollPane(table);
	       scrollPane.setBounds(20, 35, 402, 127);
	       contentPane.add(scrollPane);
	       
	       JLabel lblDescription = new JLabel("Description :");
	       lblDescription.setBounds(10, 173, 412, 14);
	       contentPane.add(lblDescription);
	       
	       textField = new JTextField();
	       textField.setBounds(20, 198, 402, 20);
	       contentPane.add(textField);
	       textField.setColumns(10);
	}
}
