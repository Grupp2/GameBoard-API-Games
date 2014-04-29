package gui;

import java.util.ArrayList;
import java.util.List;

import game.api.GameState;
import game.impl.BoardLocation;

public class GameStateToGuiTranslator {
	private GameState gameState;
	private List<String> guiNames;
	private List<String> locationNames;

	public GameStateToGuiTranslator(GameState gameState) {
		this.gameState = gameState;
		this.guiNames = new ArrayList<String>(gameState.getBoard().getLocations().size());
		this.locationNames = new ArrayList<String>(gameState.getBoard().getLocations().size());
		loadLocationNamesList();
	}
	
	private void loadLocationNamesList() {
		for (BoardLocation bl : gameState.getBoard().getLocations())
			locationNames.add(bl.getId());
	}
	
	public String getTranslatedGuiName(String locationName) {
		int locationNamePositionInList = -1;
		String result = "";
		for (int i = 0; i < locationNames.size();i++)
			if (locationNames.get(i).equals(locationName)){
				locationNamePositionInList = i;
				break;
			}
		if (locationNamePositionInList != -1)
			result = guiNames.get(locationNamePositionInList);
		return result;
	}
}
