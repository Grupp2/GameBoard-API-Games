package gui;

import translator.TranslatorAdapter;
import game.api.GameState;

public class GameBoardSizeCalculator {

	public int[] calculateBoardSize(GameState state, TranslatorAdapter ta) {
		int[] result = {0, 0};
		int xSize = 0;
		int ySize = 0;
		String currentId = "";
		String tmpChar = "";
		int tmpNum = 0;
		for (int i = 0; i < state.getBoard().getLocations().size(); i++) {
			currentId = ta.translateFromGameStateToUi(state.getBoard().getLocations().get(i).getId());
			if (tmpNum < Integer.parseInt(currentId.substring(1)))
				tmpNum = Integer.parseInt(currentId.substring(1));
			else 
				xSize = tmpNum;
			if (!tmpChar.equals(currentId.substring(0, 1))) {
				ySize++;
				tmpChar = currentId.substring(0, 1);
				tmpNum = 0;
			}
		}
		result[0] = xSize;
		result[1] = ySize;
		return result;
	}
}