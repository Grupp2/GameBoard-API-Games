package battleships.backend.classhelpers;

import game.impl.BoardLocation;

import java.util.ArrayList;
import java.util.List;

public class MoveToPieceConverter {
	
	public List<BoardLocation> pieceLocations(BoardLocation firstCoordinate, BoardLocation secondCoordinate) {
		int firstCoordinateLetterAsInteger = (int)firstCoordinate.getId().charAt(0);
		int secondCoordinateLetterAsInteger = (int)secondCoordinate.getId().charAt(0);
		Integer firstCoordinateNumber = Integer.parseInt(firstCoordinate.getId().substring(1));
		Integer secondCoordinateNumber = Integer.parseInt(secondCoordinate.getId().substring(1));
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
					firstCoordinateNumber = firstCoordinateNumber+i;
					String numberValue = firstCoordinateNumber.toString();
					result.add(new BoardLocation(letterValue+numberValue));
				} else {
					String letterValue = ""+(char)(firstCoordinateLetterAsInteger);
					secondCoordinateNumber = secondCoordinateNumber+i;
					String numberValue = secondCoordinateNumber.toString();
					result.add(new BoardLocation(letterValue+numberValue));
				}
			} else
				if (isIncreasing){
					String letterValue = ""+(char)(firstCoordinateLetterAsInteger+i);
					String numberValue = firstCoordinateNumber.toString();
					result.add(new BoardLocation(letterValue+numberValue));
				} else {
					String letterValue = ""+(char)(secondCoordinateLetterAsInteger+i);
					String numberValue = secondCoordinateNumber.toString();
					result.add(new BoardLocation(letterValue+numberValue));
				}
		return result;
	}
}