package othello.gui;

import javax.swing.JPanel;

import game.api.GameState;
import gui.ContentPanelCreatable;

public class OthelloContentCreator implements ContentPanelCreatable {
	private GameState gameState;
	
	public OthelloContentCreator(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public JPanel createGuiPanel() {
		return null;
	}

}
