package gestion_ecole.affichage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;


public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Fenetre() {
		super("gestion ecole");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout( new FlowLayout( FlowLayout.LEFT, 10, 10 ) );
		
		LeftPanel leftPanel = new LeftPanel();
		contentPane.add(leftPanel);
		
	}

}
