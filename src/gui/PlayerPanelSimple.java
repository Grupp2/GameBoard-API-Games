package gui;

import java.awt.GridLayout;
import game.impl.Player;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayerPanelSimple extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int ONE_CONTROL_ONLY = 1;
	
	public PlayerPanelSimple(Player player, int gamePieceSizeX, int gamePieceSizeY) {
		setName(player.getName());
		setBounds(1, 1, gamePieceSizeX , gamePieceSizeY);
		setLayout(new GridLayout(ONE_CONTROL_ONLY, ONE_CONTROL_ONLY));
		add(new JButton(getName()+"_"+ONE_CONTROL_ONLY));
	}
}