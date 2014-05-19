package battleships.backend.classhelpers;

import java.util.ArrayList;
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
		pieceLocationArray = pieceLocations(firstCoordinate, secondCoordinate);
		for (BoardLocation bl : state.getBoard().getLocations())
			stateLocations.put(bl.getId(), bl.getPiece().getId());
		for (int i = 0; i < pieceLocationArray.size(); i++)
			if (stateLocations.get(pieceLocationArray.get(i))!= null)
				result = "Pieces are overlapping!";
		return result;
	}
	
	private List<BoardLocation> pieceLocations(BoardLocation firstCoordinate, BoardLocation secondCoordinate) {
		int firstCoordinateLetterAsInteger = (int)firstCoordinate.getId().charAt(0);
		int secondCoordinateLetterAsInteger = (int)secondCoordinate.getId().charAt(0);
		int firstCoordinateNumber = Integer.parseInt(firstCoordinate.getId().substring(1));
		int secondCoordinateNumber = Integer.parseInt(secondCoordinate.getId().substring(1));
		int size;
		boolean isIncreasing = false;
		if (firstCoordinateLetterAsInteger == secondCoordinateLetterAsInteger)
			size = Math.abs(firstCoordinateNumber - secondCoordinateNumber) + 1;
		else
			size = Math.abs(firstCoordinateLetterAsInteger - secondCoordinateLetterAsInteger) + 1;
		if (firstCoordinateLetterAsInteger == secondCoordinateLetterAsInteger) {
			if (firstCoordinateNumber < secondCoordinateNumber)
				isIncreasing = true;
		} else 
			if (firstCoordinateLetterAsInteger < secondCoordinateLetterAsInteger)
				isIncreasing = true;
		List<BoardLocation> result = new ArrayList<BoardLocation>(size);
		for (int i = 0; i < size; i++)
			if (firstCoordinateLetterAsInteger == secondCoordinateLetterAsInteger) {
				if (isIncreasing){
					String letterValue = ""+(char)(firstCoordinateLetterAsInteger);
					String numberValue = ""+(char)(firstCoordinateNumber+i);
					result.add(new BoardLocation(letterValue+numberValue));
				} else {
					String letterValue = ""+(char)(firstCoordinateLetterAsInteger);
					String numberValue = ""+(char)(secondCoordinateNumber+i);
					result.add(new BoardLocation(letterValue+numberValue));
				}
			} else
				if (isIncreasing){
					String letterValue = ""+(char)(firstCoordinateLetterAsInteger+i);
					String numberValue = ""+(char)(firstCoordinateNumber);
					result.add(new BoardLocation(letterValue+numberValue));
				} else {
					String letterValue = ""+(char)(secondCoordinateLetterAsInteger+i);
					String numberValue = ""+(char)(secondCoordinateNumber);
					result.add(new BoardLocation(letterValue+numberValue));
				}
		return result;
	}
}
