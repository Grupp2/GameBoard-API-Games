package gui;

import game.api.GameState;
import game.io.OutputUnit;

public class OthelloGuiOutputUnit implements OutputUnit {

	@Override
	public void publish(GameState gameState) {
		loadBoard(gameState);
	}
	
	private void loadBoard(GameState gameState) {

	}
}
