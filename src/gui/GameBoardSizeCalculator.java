package gui;

import game.api.GameState;

public class GameBoardSizeCalculator {

	public int[] calculateBoardSize(GameState state) {
		int[] result = {0, 0};
		int xSize = 0;
		int ySize = 0;
		String tmpChar = "";
		int tmpNum = 0;
		for (int i = 0; i < state.getBoard().getLocations().size(); i++) {
			if (tmpNum < Integer.parseInt(state.getBoard().getLocations().get(i).getId().substring(1)))
				tmpNum = Integer.parseInt(state.getBoard().getLocations().get(i).getId().substring(1));
			else 
				xSize = tmpNum;
			if (!tmpChar.equals(state.getBoard().getLocations().get(i).getId().substring(0, 1))) {
				ySize++;
				tmpChar = state.getBoard().getLocations().get(i).getId().substring(0, 1);
				tmpNum = 0;
			}
		}
		result[0] = xSize;
		result[1] = ySize;
		return result;
	}
}