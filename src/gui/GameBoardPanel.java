package gui;

import game.api.GameState;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xSize;
	private int ySize;

	public GameBoardPanel(GameState state) {
		setBounds(1, 1, 600, 600);
		calculateBoardSize(state);
		setLayout(new GridLayout(xSize, ySize));

	}

	private void calculateBoardSize(GameState state) {
		xSize = 0;
		ySize = 0;
		String tmpChar = "";
		int tmpNum = 0;
		for (int i = 0; i < state.getBoard().getLocations().size(); i++) {
			tmpChar = state.getBoard().getLocations().get(i).getId()
					.substring(0, 1);

			if (tmpChar.equals(state.getBoard().getLocations().get(i).getId()
					.substring(0, 1))) {
				ySize++;
			}

			if (tmpNum < Integer.parseInt(state.getBoard().getLocations()
					.get(i).getId().substring(1))) {
				tmpNum = Integer.parseInt(state.getBoard().getLocations()
						.get(i).getId().substring(1));

			} else {
				xSize++;
			}

		}

	}

}
