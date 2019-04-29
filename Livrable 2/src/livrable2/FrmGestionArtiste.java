package livrable2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

public class FrmGestionArtiste extends JFrame implements ActionListener{

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
	private JScrollPane ascensseur;
	private ModeleArtiste modeleArtiste;
	private Connection connection = null;
	

	public FrmGestionArtiste() {
		super("Gestion d'artistes");
		connection = SqliteConnection.dbConnector();
		setSize(800,800);
		pane = new Container();
		pane.setLayout(new BorderLayout());
		p1 = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		f1 = new Font("Courier", Font.BOLD,25);
		f2 = new Font("Courier", Font.BOLD ,20);
	
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
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
		
		icone = new ImageIcon(App.class.getResource("spotify(R).png"));
		setIconImage(icone.getImage());
		labPhotoArt = new JLabel("",icone,JLabel.CENTER);
		
		labImageAlbum = new JLabel("",icone,JLabel.CENTER);
		
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
		tableArtiste.setPreferredScrollableViewportSize(new Dimension(270,80));
		tableArtiste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ascensseur = new JScrollPane(tableArtiste);
		
		Album a = new Album(1, 1, "Flying Stars", "Pop", 2016, icone);
		model = new DefaultListModel<Album>();
		listAlbum = new JList<Album>(model);
		model.addElement(a);
		
		checkMembre = new JCheckBox();
		checkMembre.setEnabled(false);
		
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets = new Insets(0,10,0,0);
		p1.add(labRecherche, gbc);
		
		gbc.gridy=1;
		p1.add(textRecherche, gbc);
		
		gbc.gridx=1;
		p1.add(btnRecherche, gbc);
		
		gbc.gridx=2;
		p1.add(btnQuitter, gbc);
		
		gbc.gridy=2;
		gbc.gridx=0;
		p1.add(labArtiste, gbc);
		
		gbc.gridy=3;
		gbc.gridx=0;
		p1.add(labPhotoArt, gbc);
		
		gbc.gridx=1;
		gbc.gridheight=4;
		gbc.gridwidth=3;
		gbc.insets = new Insets(0,0,0,0);
		p1.add(ascensseur, gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.insets = new Insets(-25,0,0,0);
		p1.add(btnNouv, gbc);
		
		gbc.gridy=4;
		gbc.insets = new Insets(-30,0,0,0);
		p1.add(btnAjout, gbc);
		
		gbc.gridx=0;
		gbc.gridy=6;
		gbc.insets = new Insets(0,0,0,0);
		p1.add(btnRemp, gbc);
		
		gbc.gridy=5;
		gbc.gridx=4;
		p1.add(btnModif, gbc);
		
		gbc.gridy=6;
		p1.add(btnSup, gbc);
		
		gbc.gridy=7;
		gbc.gridx=0;
		gbc.insets = new Insets(0,10,0,0);
		p1.add(labInfo, gbc);
		
		gbc.gridy=8;
		p1.add(labNum, gbc);
		
		gbc.gridx=1;
		gbc.insets = new Insets(0,0,0,0);
		p1.add(textNumero, gbc);
		
		gbc.gridx=2;
		gbc.gridheight=3;
		gbc.insets = new Insets(0,20,0,0);
		p1.add(listAlbum, gbc);
		
		gbc.gridx=4;
		gbc.gridheight=1;
		gbc.insets = new Insets(0,0,0,0);
		p1.add(labImageAlbum, gbc);
		
		gbc.gridx=0;
		gbc.gridy=9;
		gbc.insets = new Insets(0,10,0,0);
		p1.add(labNom, gbc);
		
		gbc.gridx=1;
		gbc.gridheight=2;
		gbc.insets = new Insets(0,0,0,0);
		p1.add(textNom, gbc);
		
		gbc.gridx=0;
		gbc.gridy=11;
		gbc.gridheight=1;
		gbc.insets = new Insets(10,10,0,0);
		p1.add(labMembre, gbc);
		
		gbc.gridx=1;
		gbc.insets = new Insets(0,0,0,0);
		p1.add(checkMembre, gbc);
		
		pane.add(p1, BorderLayout.NORTH);
		
		add(pane);
		this.pack();
		setResizable(true);
	}

	private ArrayList<Artiste> donneesArtiste(){
		ArrayList<Artiste> donnees = new ArrayList<Artiste>();
		try {
			String query = "select * from artistes";
			PreparedStatement pst = connection.prepareStatement(query);	
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				donnees.add(new Artiste(rs.getInt("id") ,rs.getString("nom"),rs.getBoolean("membre"),icone));
			}
			
		} catch (SQLException se) {
			System.out.println("ERREUR SQL :" + se);
		}
		return donnees;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRecherche || e.getSource() == btnSup || e.getSource() == btnRemp) {
			JOptionPane.showMessageDialog(null, "Cette fonctionnalité sera disponible lors du livrable 2!");
		
		}else if (e.getSource() == btnQuitter) {
			FrmChoixGestion frm = new FrmChoixGestion();
			frm.setVisible(true);
			this.setVisible(false);
		
		}else if (e.getSource() == btnNouv || e.getSource() == btnAjout) {
			FrmAjoutArtiste frm = new FrmAjoutArtiste();
			frm.setVisible(true);
			
		}else if (e.getSource() == btnNouv) {
			FrmAjoutArtiste frm = new FrmAjoutArtiste();
			frm.setVisible(true);
			
		}else if (e.getSource() == btnModif) {
			FrmModifierArtiste frm = new FrmModifierArtiste();
			frm.setVisible(true);
		}
		
	}
	
}

