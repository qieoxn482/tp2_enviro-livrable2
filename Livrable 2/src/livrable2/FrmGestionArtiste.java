package livrable2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FrmGestionArtiste extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel labRecherche, labArtiste, labInfo, labNum, labNom, labMembre, labPhotoArt, labImageAlbum;
	private JTextField textRecherche, textNumero, textNom;
	private JButton btnRecherche, btnQuitter, btnNouv, btnAjout, btnModif, btnSup, btnRemp;
	private JList<Album> listAlbum;
	private DefaultListModel<Album> model;
	private JCheckBox checkMembre;
	private JPanel p1;
	private Container pane;
	private GridBagConstraints gbc;
	private Font f1, f2;
	private ImageIcon icone;
	private JTable tableArtiste;
	private JScrollPane ascensseur, scrollAlbum;
	private ModeleArtiste modeleArtiste;
	private Connection connection = null;
	private SqliteConnection sqliteConn;

	public FrmGestionArtiste() {
		super("Gestion d'artistes");
		connection = SqliteConnection.dbConnector();
		sqliteConn = new SqliteConnection();
		setSize(1024, 768);
		pane = new Container();
		pane.setLayout(new BorderLayout());
		p1 = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		f1 = new Font("Courier", Font.BOLD, 25);
		f2 = new Font("Courier", Font.BOLD, 20);

		gbc.fill = GridBagConstraints.HORIZONTAL;

		labRecherche = new JLabel("Rechercher un artiste");
		labArtiste = new JLabel("Artistes");
		labArtiste.setFont(f1);
		labInfo = new JLabel("Informations");
		labInfo.setFont(f1);
		labNum = new JLabel("Numéro");
		labNum.setFont(f2);
		labNom = new JLabel("Nom");
		labNom.setFont(f2);
		labMembre = new JLabel("Membre");
		labMembre.setFont(f2);

		icone = new ImageIcon(App.class.getResource("default.png"));
		setIconImage(icone.getImage());
		labPhotoArt = new JLabel("", icone, JLabel.CENTER);

		labImageAlbum = new JLabel("", icone, JLabel.CENTER);

		textRecherche = new JTextField();
		textNumero = new JTextField();
		textNom = new JTextField();

		textNumero.setEditable(false);
		textNom.setEditable(false);

		btnRecherche = new JButton("Recherche");
		btnQuitter = new JButton("Retour");
		btnNouv = new JButton("Nouveau");
		btnAjout = new JButton("Ajouter");
		btnModif = new JButton("Modifier");
		btnSup = new JButton("Supprimer");
		btnRemp = new JButton("Remplacer");

		btnRecherche.addActionListener(this);
		btnQuitter.addActionListener(this);
		btnNouv.addActionListener(this);
		btnAjout.addActionListener(this);
		btnModif.addActionListener(this);
		btnSup.addActionListener(this);
		btnRemp.addActionListener(this);

		modeleArtiste = new ModeleArtiste(donneesArtiste());
		tableArtiste = new JTable(modeleArtiste);
		tableArtiste.setPreferredScrollableViewportSize(new Dimension(270, 80));
		tableArtiste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableArtiste.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				printInfo();
				printAlbum();
			}
		});
		
		ascensseur = new JScrollPane(tableArtiste);

		model = new DefaultListModel<Album>();
		listAlbum = new JList<Album>(model);
		
		checkMembre = new JCheckBox();
		checkMembre.setEnabled(false);

		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 10, 0, 0);
		p1.add(labRecherche, gbc);

		gbc.gridy = 1;
		p1.add(textRecherche, gbc);

		gbc.gridx = 1;
		p1.add(btnRecherche, gbc);

		gbc.gridx = 2;
		p1.add(btnQuitter, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		p1.add(labArtiste, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		p1.add(labPhotoArt, gbc);

		gbc.gridx = 1;
		gbc.gridheight = 4;
		gbc.gridwidth = 3;
		gbc.insets = new Insets(0, 0, 0, 0);
		p1.add(ascensseur, gbc);

		gbc.gridx = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(-25, 0, 0, 0);
		p1.add(btnNouv, gbc);

		gbc.gridy = 4;
		gbc.insets = new Insets(-30, 0, 0, 0);
		p1.add(btnAjout, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(0, 0, 0, 0);
		p1.add(btnRemp, gbc);

		gbc.gridy = 5;
		gbc.gridx = 4;
		p1.add(btnModif, gbc);

		gbc.gridy = 6;
		p1.add(btnSup, gbc);

		gbc.gridy = 7;
		gbc.gridx = 0;
		gbc.insets = new Insets(0, 10, 0, 0);
		p1.add(labInfo, gbc);

		gbc.gridy = 8;
		p1.add(labNum, gbc);

		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		p1.add(textNumero, gbc);

		gbc.gridx = 2;
		gbc.gridheight = 3;
		gbc.insets = new Insets(0, 20, 0, 0);
		p1.add(listAlbum, gbc);

		gbc.gridx = 4;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		p1.add(labImageAlbum, gbc);

		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.insets = new Insets(0, 10, 0, 0);
		p1.add(labNom, gbc);

		gbc.gridx = 1;
		gbc.gridheight = 2;
		gbc.insets = new Insets(0, 0, 0, 0);
		p1.add(textNom, gbc);

		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.gridheight = 1;
		gbc.insets = new Insets(10, 10, 0, 0);
		p1.add(labMembre, gbc);

		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		p1.add(checkMembre, gbc);
		p1.revalidate();
		p1.repaint();

		pane.add(p1, BorderLayout.NORTH);
		pane.revalidate();
		pane.repaint();

		add(pane);
		this.pack();
		setResizable(true);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment "
						+ "quitter l'application?",
						"Quitter", JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
	}

	private ArrayList<Artiste> donneesArtiste() {
		ArrayList<Artiste> donnees = new ArrayList<Artiste>();
		try {
			String query = "select * from artistes";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				donnees.add(new Artiste(rs.getInt("id"), rs.getString("nom"), 
						rs.getBoolean("membre"), rs.getString("photo")));
			}

		} catch (SQLException se) {
			System.out.println("ERREUR SQL :" + se);
		}
		return donnees;

	}
	
	
	private void printAlbum() {
		model.clear();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int id = (Integer) tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 0);
		
		try {
			String query = "select * from albums WHERE  id_artiste = ? ORDER BY annee ASC";
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				model.addElement(new Album(rs.getInt("id_album"), rs.getInt("id_artiste"),
						rs.getString("titre"),rs.getString("genre"), rs.getInt("annee"), 
						rs.getString("image")));
				
			}
			//connection.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String fonction;
		
		if (e.getSource() == btnRecherche) {
			JOptionPane.showMessageDialog(null, "Cette fonctionnalité sera disponible lors du livrable 2!");

		} else if (e.getSource() == btnQuitter) {
			quitter();
			

		} else if (e.getSource() == btnAjout) {
			fonction = "ajouté";
			modifierArtiste(fonction);

		} else if (e.getSource() == btnNouv) {
			sqliteConn.insertNouveau();
			updateTable();
			
		} else if (e.getSource() == btnModif) {
			fonction = "modifié";
			modifierArtiste(fonction);
			
			
		} else if (e.getSource() == btnSup) {
			//supprimerArtiste();
			
		}  else if (e.getSource() == btnRemp) {
			remplacerPhoto();
			
		} 
		
		
	}

	private void updateTable() {
		
		FrmGestionArtiste frm = new FrmGestionArtiste();
		this.setVisible(false);
		frm.setVisible(true);
		
	}
	
	private void modifierArtiste(String fonction) {
		
		if (tableArtiste.getSelectionModel().isSelectionEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Selectionné l'artiste que vous voulez " + fonction+ "!");
		}else {
			int id = (Integer) tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 0);
			String nom = tableArtiste.getModel().getValueAt( tableArtiste.getSelectedRow(), 1).toString();
			boolean membre = (Boolean) tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 2);
			sqliteConn.updateArtiste(id, nom, membre, "default.png", fonction);
			printInfo();
		}
	}
	
	
	private void quitter() {
		try {
			connection.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		FrmChoixGestion frm = new FrmChoixGestion();
		frm.setVisible(true);
		this.setVisible(false);
	}
	
	private void printInfo() {
		
		int id = (Integer) tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 0);
		String nom = tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 1).toString();
		boolean estMembre = (Boolean) tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 2);
		String photo = tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 3).toString();
		
		textNom.setText(nom);
		textNumero.setText(Integer.toString(id));
		
		if (estMembre) {
			checkMembre.setSelected(true);;
		}else {
			checkMembre.setSelected(false);
		}
		
		icone = new ImageIcon(App.class.getResource(photo));
		labPhotoArt.setIcon(icone);
		
	}
	
	private void remplacerPhoto() {
		int id = (Integer) tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 0);
		String nom = tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 1).toString();
		String photo = tableArtiste.getModel().getValueAt(tableArtiste.getSelectedRow(), 3).toString();
		
		if (tableArtiste.getSelectionModel().isSelectionEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Choisissez l'artiste que vous voulez remplacer la photo.", "Erreur!", JOptionPane.OK_OPTION);
			
		}else {
			
			if (!photo.equalsIgnoreCase("default.png")) {
				int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous mettre l'image par défault à "+ nom +"?", "Attention!", JOptionPane.YES_NO_OPTION);
				
				if (choix == JOptionPane.YES_OPTION) {
					sqliteConn.remplacerPhoto("default.png", id, nom);
					updateTable();
				}
			} else {
				JOptionPane.showMessageDialog(null, "L'artiste possède déjà l'image par défaut.", "Erreur!", JOptionPane.OK_OPTION);
			}
		}
	}
	

}
