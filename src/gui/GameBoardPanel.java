package gui;

import game.api.GameState;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xSize;
	private int ySize;
	private final int BUTTON_SIZE = 75;

	public GameBoardPanel(GameState state) {
		setBounds(1, 1, 600, 600);
		calculateBoardSize(state);
		setLayout(new GridLayout(xSize, ySize));
		addButtons(state);
	}

	private void calculateBoardSize(GameState state) {
		xSize = 0;
		ySize = 0;
		String tmpChar = "";
		int tmpNum = 0;
		for (int i = 0; i < state.getBoard().getLocations().size(); i++) {
			if (tmpNum < Integer.parseInt(state.getBoard().getLocations().get(i).getId().substring(1)))
				tmpNum = Integer.parseInt(state.getBoard().getLocations().get(i).getId().substring(1));
			else 
				xSize = tmpNum;
			if (!tmpChar.equals(state.getBoard().getLocations().get(i).getId().substring(0, 1))) {
				ySize++;
				tmpChar = state.getBoard().getLocations().get(i).getId().substring(0, 1);
				tmpNum = 0;
			}
		}
	}
	private void addButtons(GameState state) {
		for (int i=0; i < state.getBoard().getLocations().size(); i++) {
			JButton btn = new JButton();
			btn.setName(state.getBoard().getLocations().get(i).getId());
			btn.setSize(BUTTON_SIZE, BUTTON_SIZE);
			btn.setBackground(new Color(34, 177, 76, 255));
			add(btn);
		}
	}
}
