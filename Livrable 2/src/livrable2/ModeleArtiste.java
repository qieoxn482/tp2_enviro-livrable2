package livrable2;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeleArtiste extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Artiste> donnees ;
	private final String[] columnNames = {"No", "Nom", "Membres"};
	
	public ModeleArtiste(ArrayList<Artiste> donnees) {
		this.donnees = donnees;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
		
	}

	@Override
	public int getRowCount() {
		return donnees.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return donnees.get(rowIndex).getId();
		case 1:
			return donnees.get(rowIndex).getNom();
		case 2:
			return donnees.get(rowIndex).getMembre();
		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		
		  switch (columnIndex) {
	        case 0: 
	        	return int.class;
	        case 1: 
	        	return String.class;
	        case 2: 
	        	return Boolean.class;
	        default:
	        	throw new IllegalArgumentException(" Index de la colonne invalide "+ columnIndex);
		  }
	}

}
