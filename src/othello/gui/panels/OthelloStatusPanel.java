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
		addPlayerInfoLabel();
		addStatusTextLabel();
	}

	private void addPlayerInfoLabel() {
        lblPlayerInfo = new JLabel();
        setLabelProperties(lblPlayerInfo, 20);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		add(lblPlayerInfo, constraints);
	}
	
	private void addStatusTextLabel() {
        lblStatusText = new JLabel();
        setLabelProperties(lblStatusText, 15);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 0;

		add(lblStatusText, constraints);
	}

    private void setLabelProperties(JLabel label, int fontSize) {
        label.setBackground(backgroundGreen);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
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
