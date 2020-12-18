package GUI;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import Main.Membre;
import Main.sqliteConnection;


public class MembrePanel extends JPanel {
	
//Constantes du MembrePanel
	public static Connection connection = null;
	private static JTextField CodeSecret;
	private static JTextField Cartedecredit;
	private static JTextField Telephone;
	private static JTextField Nom;
	private static JTable table;

//Variables MembrePanel
	private JTextField textField_5;
	private JTextField txtTlphone;
	private JTextField textField_7;
	private JTextField textField_8;
	private JScrollPane scrollPane;
	private JButton buttonCreerMembre;
	private JButton btn_modifMembre;
	private JButton btn_suppMembre;
	

	
//Constructeur du MembrePanel.
	public MembrePanel() {
		
		connection = sqliteConnection.dbConnector();
		setTable(new JTable());
		setBounds(new Rectangle(0, 0, 940, 438));
		setLayout(null);
		
		buttonCreerMembre = new JButton("Cr�er un nouveau membre");
		buttonCreerMembre.setBounds(34, 316, 205, 33);
		buttonCreerMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membre.Creer_membre();
				Membre.loadTablemembres();
			}
		});
		add(buttonCreerMembre);
		
	//===========================
	//Constantes JtextField
		setCodeSecret(new JTextField());
		getCodeSecret().setColumns(10);
		getCodeSecret().setBounds(684, 412, 180, 20);
		add(getCodeSecret());

		setNom(new JTextField());
		getNom().setColumns(10);
		getNom().setBounds(684, 322, 180, 20);
		add(getNom());
		
		setCartedecredit(new JTextField());
		getCartedecredit().setColumns(10);
		getCartedecredit().setBounds(684, 381, 180, 20);
		add(getCartedecredit());
		
		setTelephone(new JTextField());
		getTelephone().setColumns(10);
		getTelephone().setBounds(684, 350, 180, 20);
		add(getTelephone());
	//===========================
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("    Nom:");
		textField_5.setColumns(10);
		textField_5.setBounds(639, 322, 40, 20);
		add(textField_5);
		
		txtTlphone = new JTextField();
		txtTlphone.setEditable(false);
		txtTlphone.setText("    T\u00E9l\u00E9phone:");
		txtTlphone.setColumns(10);
		txtTlphone.setBounds(607, 350, 72, 20);
		add(txtTlphone);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("    Code secret:");
		textField_7.setColumns(10);
		textField_7.setBounds(599, 412, 80, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setText("    Carte de Cr\u00E9dit/D\u00E9bit:");
		textField_8.setColumns(10);
		textField_8.setBounds(545, 381, 134, 20);
		add(textField_8);
	
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 11, 859, 298);
		add(scrollPane);
		
		
		try {
			String query = "select ID,Nom,Telephone from MembreInfo";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			getTable().setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		getTable().getColumnModel().getColumn(0).setPreferredWidth(291);
		getTable().getColumnModel().getColumn(1).setPreferredWidth(356);
		scrollPane.setViewportView(getTable());
		
		
		
		
		btn_modifMembre = new JButton("Modifier un membre");
		btn_modifMembre.setBounds(34, 356, 205, 33);
		btn_modifMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membre.modifier_membre();
				Membre.loadTablemembres();
			}
		});
		add(btn_modifMembre);
		
		
		btn_suppMembre = new JButton("Supprimer un membre");
		btn_suppMembre.setBounds(34, 399, 205, 33);
		btn_suppMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membre.supprimer_membre();
				Membre.loadTablemembres();
			}
		});
		add(btn_suppMembre);
	}

	

	
//Getters et setters des constantes JTextFields du Panel

	public static JTextField getNom() {
		return Nom;
	}



	public void setNom(JTextField nom) {
		Nom = nom;
	}



	public static JTextField getTelephone() {
		return Telephone;
	}



	public void setTelephone(JTextField telephone) {
		Telephone = telephone;
	}



	public static JTextField getCodeSecret() {
		return CodeSecret;
	}



	public void setCodeSecret(JTextField codeSecret) {
		CodeSecret = codeSecret;
	}



	public static JTextField getCartedecredit() {
		return Cartedecredit;
	}



	public void setCartedecredit(JTextField cartedecredit) {
		Cartedecredit = cartedecredit;
	}



	public static JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}



	public static JTable getModel() {
		return table;
	}

	
}
