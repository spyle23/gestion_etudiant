package gestion_ecole.affichage;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	public CreateStudent() {
		super();
		JLabel label = new JLabel("Create student works");
		this.setBackground(Color.blue);
		this.add(label);
	}
	
}
