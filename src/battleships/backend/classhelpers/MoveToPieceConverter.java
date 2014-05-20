package battleships.backend.classhelpers;

import game.impl.BoardLocation;

import java.util.ArrayList;
import java.util.List;

public class MoveToPieceConverter {
	
	public List<BoardLocation> pieceLocations(BoardLocation firstCoordinate, BoardLocation secondCoordinate) {
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