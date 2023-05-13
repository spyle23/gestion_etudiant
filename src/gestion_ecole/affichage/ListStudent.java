package gestion_ecole.affichage;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListStudent extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ListStudent() {
		super();
		JLabel label = new JLabel("List student works");
		this.setBackground(Color.red);
		this.add(label);
	}
	
}
