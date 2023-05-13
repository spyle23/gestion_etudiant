package gestion_ecole.affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	List<MenuButton> buttons = new ArrayList<MenuButton>();
	
	private void initialiseButton() {
		this.buttons.add(new MenuButton("Liste des étudiants", () -> {
			System.out.println("Liste des étudiants");
		}));
		this.buttons.add(new MenuButton( "Ajouter un nouveau étudiant", () -> {
			System.out.println("Ajouter un nouveau étudiant");
		}));
		this.buttons.add(new MenuButton ("Modifier un étudiant", () -> {
			System.out.println("Modifier un étudiant");
		}));
		this.buttons.add(new MenuButton( "supprimer un étudiant", () -> {
			System.out.println("supprimer un étudiant");
		}));
	}
	
	private void addBtnsToPanel() {
		for (int i = 0; i < this.buttons.size(); i++) {
			this.add(this.buttons.get(i));
		}
	}

	public LeftPanel() {
		this.setPreferredSize( new Dimension(300, 300) );
		
		this.initialiseButton();
		
		this.setLayout( new GridLayout(this.buttons.size() + 1, 1, 30, 20) );
		
		JLabel title = new JLabel("Gestion de l'école");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.CYAN);
		title.setFont(new Font("Arial", Font.BOLD, 16));
		
		this.add(title);
		
		this.addBtnsToPanel();
	}
}
