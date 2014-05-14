package othello.gui.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OthelloStatusPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblStatusText;
	private JLabel lblPlayerInfo;
	private GridBagConstraints c = new GridBagConstraints();
	private Color backgroundGreen = new Color(34, 177, 76, 255);
	
	public OthelloStatusPanel() {
		setLayout(new GridBagLayout());
		setBackground(backgroundGreen);
		this.lblPlayerInfo = new JLabel();
		this.lblStatusText = new JLabel();
		addPlayerInfoLabel();
		addStatusTextLabel();
	}

	private void addPlayerInfoLabel() {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 0;
		add(lblPlayerInfo, c);
	}
	
	private void addStatusTextLabel() {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0,20,0,0);
		c.gridx = 2;
		c.gridy = 0;
		add(lblStatusText, c);
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
