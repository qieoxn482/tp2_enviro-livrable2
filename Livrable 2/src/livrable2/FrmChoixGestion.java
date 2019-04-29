package livrable2;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrmChoixGestion extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	JButton albums, artistes, quitter, aideEnLigne;
	JLabel bienvenue, textAlbum, textArtiste, label;
	JPanel pannel, pannel2, pannel3, pannel4;
	Font font1, font2;
	ImageIcon icone;

	public FrmChoixGestion() { 
		super("Motify");
		setSize(450,650);
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.lightGray);
		icone = new ImageIcon(App.class.getResource("spotify.png"));
		setIconImage(icone.getImage());
		
		font1 = new Font("Courier", Font.BOLD,25);
		font2 = new Font("Courier", Font.BOLD,18);
        
        quitter = new JButton("Quitter");
        albums = new JButton("Albums");
        artistes = new JButton("Artistes");
        aideEnLigne = new JButton("Aide!");
        
        quitter.addActionListener(this);
        albums.addActionListener(this);
        artistes.addActionListener(this);
        aideEnLigne.addActionListener(this);
        
        bienvenue = new JLabel("BIENVENUE SUR MOTIFY!");
        bienvenue.setFont(font1);
        textAlbum = new JLabel("Pour gerer les albums...");
        textAlbum.setFont(font2);
        textArtiste = new JLabel("Pour gerer les artistes...");
        textArtiste.setFont(font2);
        label = new JLabel("",icone,JLabel.CENTER);
        
        pannel = new JPanel();
        pannel2 = new JPanel();
        pannel3 = new JPanel();
        pannel4 = new JPanel();
        
        add(bienvenue);
        pannel.add(textAlbum);
        pannel2.add(textArtiste);
        pannel.add(albums);
        pannel2.add(artistes);
        pannel3.add(quitter);
        pannel3.add(aideEnLigne);
        pannel4.add(label);
        
        pannel.setBackground(Color.lightGray);
        pannel2.setBackground(Color.lightGray);
        pannel3.setBackground(Color.lightGray);
        
        add(pannel);
        add(pannel2);
        add(pannel3);
        add(pannel4);
        
        setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == quitter) {
			System.exit(0);
			
		}else if (e.getSource() == artistes) {
			FrmGestionArtiste frm = new FrmGestionArtiste();
			frm.setVisible(true);
			this.setVisible(false);
			 
		}else if (e.getSource() == albums) {
			JOptionPane.showMessageDialog(null, "Après la réalisation que cette partie du TP est un bonus, \n" +
					"la gestion des albums sera en construction indéfiniment.");
		}else if (e.getSource() == aideEnLigne) {
			Desktop desktop = Desktop.getDesktop();
			try{
				File fleFichier= new File("src/livrable2/Aide.chm");
				//File fleFichier;
				//fleFichier = new File(getClass().getResource("Aide.chm").toString());
				desktop.open(fleFichier);
			} catch(Exception msg) {
				System.out.println(msg);
			}
			
		}
		
	}

}
