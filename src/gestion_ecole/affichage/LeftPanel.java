package gestion_ecole.affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	List<String> buttonText = new ArrayList<String>();
	
	private void initialiseList() {
		this.buttonText.add("Liste des étudiants");
		this.buttonText.add("Ajouter un nouveau étudiant");
		this.buttonText.add("Modifier un étudiant");
		this.buttonText.add("supprimer un étudiant");
	}

	private void createButtons() {
		for (int i = 0; i < this.buttonText.size(); i++) {
			JButton tempButton = new JButton(this.buttonText.get(i));
			this.add(tempButton);
		}		
	}
	public LeftPanel() {
		this.setPreferredSize( new Dimension(300, 300) );
		
		this.initialiseList();
		
		this.setLayout( new GridLayout(this.buttonText.size() + 1, 1, 30, 20) );
		
		JLabel title = new JLabel("Gestion de l'école");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.CYAN);
		title.setFont(new Font("Arial", Font.BOLD, 16));
		
		this.add(title);
		
		this.createButtons();
	}
}
