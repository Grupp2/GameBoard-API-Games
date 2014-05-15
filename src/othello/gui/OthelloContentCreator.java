package othello.gui;

import javax.swing.JPanel;

import othello.gui.panels.OthelloContentPanel;
import game.api.GameState;
import gui.ContentPanelCreatable;

public class OthelloContentCreator implements ContentPanelCreatable {
	private GameState gameState;
	private OthelloGuiInputUnit inputUnit;
	
	public OthelloContentCreator(GameState gameState, OthelloGuiInputUnit inputUnit) {
		this.gameState = gameState;
		this.inputUnit = inputUnit;
	}

	@Override
	public OthelloContentPanel createGuiPanel() {
		OthelloContentPanel contentPane = new OthelloContentPanel(gameState, inputUnit);
		return contentPane;
	}
}
