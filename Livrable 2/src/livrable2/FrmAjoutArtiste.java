package livrable2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmAjoutArtiste extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel labAjouter, labNum, labNom, labMembre;
	private JTextField textNom, textNumero;
	private JCheckBox checkBoxMembre;
	private JPanel panel1, panel2, panel3, panel4;
	private JButton btnAjouter, btnAnnuler;
	
	public FrmAjoutArtiste() {
		setTitle("Ajouter un Artiste");
		setSize(400, 200);
		setLayout(new FlowLayout());
		labAjouter = new JLabel("Ajouter un Artiste!");
		labNum = new JLabel("Numero :");
		labNom = new JLabel("Nom :");
		labMembre = new JLabel("Membre :");
		
		textNom = new JTextField();
		textNumero = new JTextField();
		
		textNom.setPreferredSize(new Dimension(250, 20));
		textNumero.setPreferredSize(new Dimension(250, 20));
		
		checkBoxMembre = new JCheckBox();
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		btnAjouter = new JButton("Ajouter");
		btnAnnuler = new JButton("Annuler");
		
		btnAjouter.addActionListener(this);
		btnAnnuler.addActionListener(this);
		
		panel1.add(labNum);
		panel1.add(textNumero);
		
		panel2.add(labNom);
		panel2.add(textNom);
		
		panel3.add(labMembre);
		panel3.add(checkBoxMembre);
		
		panel4.add(btnAjouter);
		panel4.add(btnAnnuler);
		
		add(labAjouter);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAjouter) {
			JOptionPane.showMessageDialog(null, "Cette fonctionnalité sera disponible lors du livrable 2!");
		}else if (e.getSource() == btnAnnuler) {
			this.setVisible(false);
		}
		
	}
	
	
	
}
