package gui.panels;

import game.api.GameState;
import gui.GameBoardSizeCalculator;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {
	private int xSize;
	private int ySize;
	private static final long serialVersionUID = 1L;
	private final int BUTTON_SIZE = 75;
	private Color backgroundGreen = new Color(34, 177, 76, 255);

	public GameBoardPanel(GameState state) {
		setBounds(1, 1, 600, 600);
		calculateBoardSize(state);
		setLayout(new GridLayout(xSize, ySize));
		addButtons(state);
	}
	
	private void calculateBoardSize(GameState gameState) {
		GameBoardSizeCalculator calc = new GameBoardSizeCalculator();
		int[] result = calc.calculateBoardSize(gameState);
		this.xSize = result[0];
		this.ySize = result[1];
	}

	
	private void addButtons(GameState state) {
		for (int i=0; i < state.getBoard().getLocations().size(); i++) {
			JButton btn = new JButton();
			btn.setName(state.getBoard().getLocations().get(i).getId());
			btn.setSize(BUTTON_SIZE, BUTTON_SIZE);
			btn.setBackground(backgroundGreen);
			add(btn);
		}
	}
}
