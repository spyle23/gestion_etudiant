package gestion_ecole.affichage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	
	public RightPanel() {
		super();
		this.setPreferredSize(new Dimension(400, 400));
		this.setCardLayout(new CardLayout());
		this.setLayout(cardLayout);
		
		JPanel card1 = new JPanel();
        card1.setBackground(Color.RED);
        JLabel label1 = new JLabel("Card 1");
        card1.add(label1);

        JPanel card2 = new JPanel();
        card2.setBackground(Color.GREEN);
        JLabel label2 = new JLabel("Card 2");
        card2.add(label2);

        JPanel card3 = new JPanel();
        card3.setBackground(Color.BLUE);
        JLabel label3 = new JLabel("Card 3");
        card3.add(label3);
        
        this.add(card1, "card1");
        this.add(card2, "card2");
        this.add(card3, "card3");
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

}
