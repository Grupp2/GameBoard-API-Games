package battleships.gui.panels;

import java.awt.GridLayout;

import game.api.GameState;
import gui.GameBoardSizeCalculator;

import javax.swing.JButton;
import javax.swing.JPanel;

import translator.TranslatorAdapter;


public class GameGridPanel extends JPanel {
    private final int BUTTON_SIZE = 75;
    private int xSize;
    private int ySize;
    
    public GameGridPanel(GameState gameState, TranslatorAdapter ta) {
	setBounds(1, 1, 600, 600);
	calculateBoardSize(gameState, ta);
	setLayout(new GridLayout(xSize, ySize));
	addButtons(gameState);
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
		add(btn);
	}
    }
}
