package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OthelloStatusPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblStatusText;
	private JLabel lblPlayerInfo;
	
	public OthelloStatusPanel() {
		setLayout(new GridLayout(1, 2));
		this.lblPlayerInfo = new JLabel();
		this.lblStatusText = new JLabel();
		add(lblPlayerInfo);
		add(lblStatusText);
	}
	
	public OthelloStatusPanel getStatusPanel() {
		return this;
	}
	
	public JLabel getPlayerInfoLabel() {
		return this.lblPlayerInfo;
	}
	
	public JLabel getStatusTextLabel() {
		return this.lblStatusText;
	}
}
