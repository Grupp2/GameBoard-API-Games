package othello.gui.panels;

import java.awt.*;
import javax.swing.*;

public class OthelloStatusPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblStatusText;
	private JLabel lblPlayerInfo;
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
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.LINE_START;

        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		add(lblPlayerInfo, constraints);
	}
	
	private void addStatusTextLabel() {

        GridBagConstraints constraints = new GridBagConstraints();


        constraints.anchor = GridBagConstraints.LINE_START;

        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 0;

		add(lblStatusText, constraints);
	}

	public JLabel getPlayerInfoLabel() {
		return this.lblPlayerInfo;
	}
	
	public JLabel getStatusTextLabel() {
		return this.lblStatusText;
	}


    public void setTurnLabel(ImageIcon icon, String text){
        this.lblPlayerInfo.setText(text);
        this.lblPlayerInfo.setIcon(icon);
    }

    public void setMessageLabel(String text){
        this.lblStatusText.setText(text);
    }

    public void setMessageFont(Font font){
        this.lblStatusText.setFont(font);
    }
}
