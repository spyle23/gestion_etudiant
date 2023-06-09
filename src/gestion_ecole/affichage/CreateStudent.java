package gestion_ecole.affichage;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestion_ecole.service.DBService;

public class CreateStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField firstname;
	private JTextField lastname;
	private DBService service;
	
	
	public CreateStudent() {
		super();
		this.setPreferredSize(new Dimension(500, 400));
		JLabel label = new JLabel("Nouveau étudiant");
		JButton button = new JButton("Créer");
		
		this.firstname = new JTextField("Nom");
		this.lastname = new JTextField("Prénom");
		
		label.setPreferredSize(new Dimension(400, 30));
		button.setPreferredSize(new Dimension(400, 30));
		this.firstname.setPreferredSize(new Dimension(400, 30));
		this.lastname.setPreferredSize(new Dimension(400, 30));
		
		this.add(label);
		this.add(firstname);
		this.add(lastname);
		this.add(button);
		
		button.addActionListener((e)->{
			try {				
				String message = this.getService().createNewStudent(this.firstname.getText(), this.lastname.getText());
				JOptionPane.showMessageDialog(null, message, "creation étudiant", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});
	}
	
	public DBService getService() {
		return service;
	}
	public void setService(DBService service) {
		this.service = service;
	}
	public JTextField getFirstname() {
		return firstname;
	}
	public void setFirstname(JTextField firstname) {
		this.firstname = firstname;
	}
	public JTextField getLastname() {
		return lastname;
	}
	public void setLastname(JTextField lastname) {
		this.lastname = lastname;
	}
}
