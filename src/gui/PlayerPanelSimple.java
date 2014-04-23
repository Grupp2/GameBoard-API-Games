package gui;

import java.awt.Font;
import java.awt.GridLayout;
import game.impl.Player;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerPanelSimple extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int ONE_CONTROL_ONLY = 1;
	private JLabel lblRemainingUndeployedGamePieces;
	
	public PlayerPanelSimple(Player player, int gamePieceSizeX, int gamePieceSizeY) {
		setName(player.getName());
		setBounds(1, 1, gamePieceSizeX , gamePieceSizeY);
		setLayout(new GridLayout(ONE_CONTROL_ONLY, ONE_CONTROL_ONLY));
		lblRemainingUndeployedGamePieces = new JLabel(getName()+"_"+ONE_CONTROL_ONLY); 
		lblRemainingUndeployedGamePieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemainingUndeployedGamePieces.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblRemainingUndeployedGamePieces);
	}
}