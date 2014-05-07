package gui.panels;

import java.awt.GridLayout;
import game.impl.Player;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayerPanelVertical extends JPanel {

	private static final long serialVersionUID = 1L;
	private int noOfPieces;
	
	public PlayerPanelVertical(Player player, int gamePieceSizeX, int gamePieceSizeY) {
		setName(player.getName());
		noOfPieces = player.getPieces().size();
		setBounds(1, 1, gamePieceSizeX, gamePieceSizeY * noOfPieces);
		setLayout(new GridLayout(noOfPieces, 1));
		addButtons();
	}

	private void addButtons(){
		for (int i=0; i<noOfPieces; i++)
			add(new JButton(getName()+"_"+i));
	}
}