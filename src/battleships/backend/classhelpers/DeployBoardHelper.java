package battleships.backend.classhelpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import game.impl.BoardLocation;
import battleships.backend.State;

public class DeployBoardHelper {
	private List<BoardLocation> pieceLocationArray;
	
	public String checkPieceLocations(BoardLocation firstCoordinate, BoardLocation secondCoordinate, State state) {
		String result = "";
		Map<String, String> stateLocations = new HashMap<String, String>(200);
		MoveToPieceConverter mpc = new MoveToPieceConverter();
		pieceLocationArray = mpc.pieceLocations(firstCoordinate, secondCoordinate);
		for (BoardLocation bl : state.getBoard().getLocations()){
			String tempString = "";
			if (!bl.getPieces().isEmpty())
				tempString = bl.getPiece().getId();
			stateLocations.put(bl.getId(), tempString);
		}
		for (int i = 0; i < pieceLocationArray.size(); i++)
			if (stateLocations.get(pieceLocationArray.get(i).getId())!= "")
				result = "Pieces are overlapping!";
		return result;
	}

	public int getPieceLocationArraySize() {
		return pieceLocationArray.size();
	}
}
