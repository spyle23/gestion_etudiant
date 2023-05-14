package gestion_ecole.affichage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestion_ecole.service.DBService;

import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	private List<MenuButton> buttons = new ArrayList<MenuButton>();
	private RightPanel rightPanel;
	private DBService dbservice;
	
	
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
			this.getRightPanel().getCardLayout().show(this.getRightPanel(), "createStudent");
			this.getRightPanel().getCreateStudent().setService(this.dbservice);
		}));
		this.buttons.add(new MenuButton ("Modifier un étudiant", () -> {
			this.getRightPanel().getCardLayout().show(this.getRightPanel(), "updateStudent");
			this.getRightPanel().getUpdateStudent().setService(dbservice);
		}));
		this.buttons.add(new MenuButton( "supprimer un étudiant", () -> {
			JPanel panel = new JPanel();
	        JTextField textField = new JTextField(20);
	        panel.add(textField);
			int option = JOptionPane.showConfirmDialog(null, panel, "Entrer l'identifiant de l'utilisateur", JOptionPane.OK_CANCEL_OPTION);
			 if (option == JOptionPane.OK_OPTION) {
				 	try {
				 		String userID = textField.getText();
				 		int id = Integer.parseInt(userID);
				 		this.getDbservice().deleteStudent(id);
					} catch (SQLException error) {
						System.out.println(error.toString());
					}
				 	catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
		    } else {
		        System.out.println("close dialog");
		    }
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
		try {			
			this.setDbservice(new DBService());
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("une erreur s'est produite");
		}
		
	}

	public DBService getDbservice() {
		return dbservice;
	}

	public void setDbservice(DBService dbservice) {
		this.dbservice = dbservice;
	}

}
