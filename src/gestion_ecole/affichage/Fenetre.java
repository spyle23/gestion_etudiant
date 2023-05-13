package gestion_ecole.affichage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;


public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	private List<MenuButton> buttons = new ArrayList<MenuButton>();
	private RightPanel rightPanel;
	
	
	public RightPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(RightPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public List<MenuButton> getButtons() {
		return buttons;
	}

	public void setButtons(List<MenuButton> buttons) {
		this.buttons = buttons;
	}

	private void initialiseButton() {
		this.buttons.add(new MenuButton("Liste des étudiants", () -> {
			this.getRightPanel().getCardLayout().first(this.getRightPanel());
		}));
		this.buttons.add(new MenuButton( "Ajouter un nouveau étudiant", () -> {
			this.getRightPanel().getCardLayout().show(this.getRightPanel(), "card2");
		}));
		this.buttons.add(new MenuButton ("Modifier un étudiant", () -> {
			System.out.println("Modifier un étudiant");
		}));
		this.buttons.add(new MenuButton( "supprimer un étudiant", () -> {
			System.out.println("supprimer un étudiant");
		}));
	}
	
	public Fenetre() {
		super("gestion ecole");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.rightPanel = new RightPanel();
		this.initialiseButton();
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout( new FlowLayout( FlowLayout.LEFT, 10, 10 ) );
		
		LeftPanel leftPanel = new LeftPanel(this.getButtons());
		contentPane.add(leftPanel);
		contentPane.add(this.rightPanel);
		
	}

}
