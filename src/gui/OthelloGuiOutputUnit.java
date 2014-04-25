package gui;

import game.api.GameState;
import game.io.OutputUnit;

public class OthelloGuiOutputUnit implements OutputUnit {
	private OthelloGameFrame gameFrame;

	@Override
	public void publish(GameState gameState) {
		loadBoard(gameState);
	}
	
	public void setGameFrame(OthelloGameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	private void loadBoard(GameState gameState) {

	}
}
