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

		if (firstCoordinateLetterAsInteger == secondCoordinateLetterAsInteger)
			size = Math.abs(firstCoordinateNumber - secondCoordinateNumber) + 1;
		else
			size = Math.abs(firstCoordinateLetterAsInteger - secondCoordinateLetterAsInteger) + 1;
		if (firstCoordinateLetterAsInteger == secondCoordinateLetterAsInteger) {
			if (firstCoordinateNumber > secondCoordinateNumber){
				BoardLocation tmp = firstCoordinate;
				firstCoordinate = secondCoordinate;
				secondCoordinate = tmp;
			}
		} else 
			if (firstCoordinateLetterAsInteger > secondCoordinateLetterAsInteger){
				BoardLocation tmp = firstCoordinate;
				firstCoordinate = secondCoordinate;
				secondCoordinate = tmp;
			}
		firstCoordinateLetterAsInteger = (int)firstCoordinate.getId().charAt(0);
		secondCoordinateLetterAsInteger = (int)secondCoordinate.getId().charAt(0);
		firstCoordinateNumber = Integer.parseInt(firstCoordinate.getId().substring(1));
		secondCoordinateNumber = Integer.parseInt(secondCoordinate.getId().substring(1));
		List<BoardLocation> result = new ArrayList<BoardLocation>(size);
		for (int i = 0; i < size; i++)
			if (firstCoordinateLetterAsInteger == secondCoordinateLetterAsInteger) {
					String letterValue = ""+(char)(firstCoordinateLetterAsInteger);
					String numberValue = firstCoordinateNumber.toString();
					result.add(new BoardLocation(letterValue+numberValue));
					firstCoordinateNumber = firstCoordinateNumber+1;
			} else {
					String letterValue = ""+(char)(firstCoordinateLetterAsInteger+i);
					String numberValue = firstCoordinateNumber.toString();
					result.add(new BoardLocation(letterValue+numberValue));
			}
		return result;
	}
}