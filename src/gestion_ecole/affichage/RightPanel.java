package gestion_ecole.affichage;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private ListStudent listStudent;
	private CreateStudent createStudent;
	
	public RightPanel() {
		super();
		this.setPreferredSize(new Dimension(400, 400));
		this.setCardLayout(new CardLayout());
		this.setLayout(cardLayout);
		
		this.listStudent = new ListStudent();
		this.createStudent = new CreateStudent();
		
		this.add(this.listStudent, "listStudent");
		this.add(this.createStudent, "createStudent");
		
	}

	public ListStudent getListStudent() {
		return listStudent;
	}

	public void setListStudent(ListStudent listStudent) {
		this.listStudent = listStudent;
	}

	public CreateStudent getCreateStudent() {
		return createStudent;
	}

	public void setCreateStudent(CreateStudent createStudent) {
		this.createStudent = createStudent;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

}
