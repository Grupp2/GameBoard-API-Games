package battleships.gui.panels.logic;

import java.util.ArrayList;
import java.util.List;

import game.api.GameState;

public class BattleshipsDeployLogic {
	private List<String> gamePieceList = new ArrayList<String>();
	
	public BattleshipsDeployLogic(GameState gameState) {
		createGamePieceList(gameState);
	}
	
	private void createGamePieceList(GameState gameState) {
		for (int i = 0; i < gameState.getPlayers().get(i).getPieces().size();i++)
			this.gamePieceList.add( gameState.getPlayers().get(0).getPieces().get(i).getId());
	}
	
	public List<String> getgamePieceList() {
		return gamePieceList;
	}
}
