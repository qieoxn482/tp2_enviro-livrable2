package livrable2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FrmIdentification extends JFrame implements ActionListener{
	JTextField utilisateur, motPasse;
	JPasswordField pw;
	JButton quitter, valider;
	JLabel text, text2, text3;
	JPanel pannel, pannel2, pannel3;
	ImageIcon icone;
	
	private static final long serialVersionUID = 1L;

	public FrmIdentification() { 
		super("Identification");
		setSize(500,180);
		setLayout(new FlowLayout());
		icone = new ImageIcon(App.class.getResource("spotify.png"));
		setIconImage(icone.getImage());
		getContentPane().setBackground(Color.lightGray);
		
        utilisateur = new JTextField();
        utilisateur.setPreferredSize(new Dimension(350,20));
        utilisateur.getDocument().addDocumentListener(new DocumentListener() {
      	  public void changedUpdate(DocumentEvent e) {
      	    changed();
      	  }
      	  public void removeUpdate(DocumentEvent e) {
      	    changed();
      	  }
      	  public void insertUpdate(DocumentEvent e) {
      	    changed();
      	  }
      });	
        
        pw = new JPasswordField();
        pw.setPreferredSize(new Dimension(350,20));
        pw.getDocument().addDocumentListener(new DocumentListener() {
        	  public void changedUpdate(DocumentEvent e) {
        	    changed();
        	  }
        	  public void removeUpdate(DocumentEvent e) {
        	    changed();
        	  }
        	  public void insertUpdate(DocumentEvent e) {
        	    changed();
        	  }
        });	
        
        quitter = new JButton("Quitter");
        valider = new JButton("Valider");
        valider.setEnabled(false);
        
        quitter.addActionListener(this);
        valider.addActionListener(this);
        
        text = new JLabel("Connexion � l�application");
        text2 = new JLabel("Nom d'utilisateur:");
        text3 = new JLabel("Mot de passe:      ");
        
        pannel = new JPanel();
        pannel2 = new JPanel();
        pannel3 = new JPanel();
        
        add(text);
        pannel.add(text2);
        pannel.add(utilisateur);
        pannel2.add(text3);
        pannel2.add(pw);
        pannel3.add(valider);
        pannel3.add(quitter);
        
        pannel.setBackground(Color.lightGray);
        pannel2.setBackground(Color.lightGray);
        pannel3.setBackground(Color.lightGray);
        
        add(pannel);
        add(pannel2);
        add(pannel3);
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				quitter();
			}
		});
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String pass;
		pass = new String(pw.getPassword());
		
		if (e.getSource() == quitter) {
			quitter();
			
		}else if (e.getSource() == valider) {
			
			if (! (utilisateur.getText().equals("andrew2time") && 
					pass.equals("password")) ) {
				
				JOptionPane.showMessageDialog(null, "Le nom d'utilisateur ou le mot "
						+ "de passe est incorrect.", "Erreur", JOptionPane.OK_OPTION);
				
				utilisateur.setText("");
				pw.setText("");
				
			}else {
				
				FrmChoixGestion frm = new FrmChoixGestion();
				frm.setVisible(true);
				this.setVisible(false);
				
			}
		}
	}
	
	private void changed() {
		
		if (utilisateur.getText().equals("") || pw.getPassword().length == 0) {
			valider.setEnabled(false);
		} else {
			valider.setEnabled(true);
		}
	}
	
	private void quitter() {
		int confirmed = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment "
				+ "quitter l'application?","Quitter", JOptionPane.YES_NO_OPTION);

		if (confirmed == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
