package battleships.gui.panels;

import game.api.GameState;
import gui.GameBoardSizeCalculator;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import translator.TranslatorAdapter;

public class BattleshipDeployPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int xSize;
	private int ySize;
	private final int BUTTON_SIZE = 45;
	private Color backgroundGreen = new Color(34, 177, 76, 255);

	public BattleshipDeployPanel(GameState gameState, TranslatorAdapter ta) {
		setBounds(1, 1, 600, 600);
		setLayout(new GridLayout(xSize, ySize));
		calculateBoardSize(gameState, ta);
		addButtons(gameState);

	}

	private void calculateBoardSize(GameState gameState, TranslatorAdapter ta) {
		GameBoardSizeCalculator calc = new GameBoardSizeCalculator();
		int[] result = calc.calculateBoardSize(gameState, ta);
		this.xSize = result[0];
		this.ySize = result[1];
	}

	private void addButtons(GameState gameState) {
		for (int i = 0; i < gameState.getBoard().getLocations().size(); i++) {
			JButton btn = new JButton();
			btn.setName(gameState.getBoard().getLocations().get(i).getId());
			btn.setSize(BUTTON_SIZE, BUTTON_SIZE);
			btn.setBackground(backgroundGreen);
			add(btn);
		}

	}

}
