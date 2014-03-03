package com.esprit.admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

public class RemoveCategoriePage extends JFrame {

	private JPanel contentPane;
	static RemoveCategoriePage frame;
	private JTable table;
	Categories c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveCategoriePage f = new RemoveCategoriePage();
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
	public RemoveCategoriePage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ID = Integer.parseInt(table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString());
				System.out.println(ID);				c=new Categories();
				c.DeleteSelectedCategorieById(ID);
				JOptionPane.showMessageDialog(null,"Categorie deleted successfully");
				
			}
		});
		btnRemove.setBounds(345, 238, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CategoriesManagmentPage cmp=new CategoriesManagmentPage();
				cmp.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(246, 238, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblListCategories = new JLabel("List Categories :");
		lblListCategories.setBounds(10, 11, 424, 14);
		contentPane.add(lblListCategories);
		
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
	       scrollPane.setBounds(20, 36, 402, 191);
	       contentPane.add(scrollPane);

		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 402, 191);
		contentPane.add(scrollPane);*/
	}
}
