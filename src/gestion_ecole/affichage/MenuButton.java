package gestion_ecole.affichage;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

interface MyFunction {
	void exec();
}

public class MenuButton extends JButton {
	private static final long serialVersionUID = 1L;
	private MyFunction callback;
	public MenuButton(String name, MyFunction callback) {
		super(name);
		this.setCallback(callback);
		this.addActionListener((ActionEvent e)-> {
			this.performedAction();
		});
	}
	public MyFunction getCallback() {
		return callback;
	}
	public void setCallback(MyFunction callback) {
		this.callback = callback;
	}
	public void performedAction() {
		this.callback.exec();
	}
}
