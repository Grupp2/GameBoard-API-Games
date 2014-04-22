package gui;

import java.awt.GridLayout;
import game.impl.Player;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int noOfPieces;
	
	public PlayerPanel(Player player, boolean useVerticalLayout, int gamePieceSizeX, int gamePieceSizeY) {
		setName(player.getName());
		noOfPieces = player.getPieces().size();
		if (useVerticalLayout)
			setBounds(1, 1, gamePieceSizeX, gamePieceSizeY * noOfPieces);
		else
			setBounds(1, 1, gamePieceSizeX * noOfPieces, gamePieceSizeY);
		setLayout(new GridLayout(noOfPieces, 1));
		addButtons();
	}

	private void addButtons(){
		for (int i=0; i<noOfPieces; i++)
			add(new JButton(getName()+"_"+i));
	}
}