package gui.panels;

import game.api.GameState;
import gui.GameBoardSizeCalculator;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import translator.TranslatorAdapter;

public class GameBoardPanel extends JPanel {
	private int xSize;
	private int ySize;
	private static final long serialVersionUID = 1L;
	private final int BUTTON_SIZE = 75;
	private Color backgroundGreen = new Color(34, 177, 76, 255);

	public GameBoardPanel(GameState state, TranslatorAdapter ta) {
		setPreferredSize(new Dimension(600, 600));

		calculateBoardSize(state, ta);
		setLayout(new GridLayout(xSize, ySize));
		addButtons(state);
	}
	
	private void calculateBoardSize(GameState gameState, TranslatorAdapter ta) {
		GameBoardSizeCalculator calc = new GameBoardSizeCalculator();
		int[] result = calc.calculateBoardSize(gameState, ta);
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
