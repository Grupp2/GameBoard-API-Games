package battleships.backend.classhelpers;

import battleships.backend.State;
import game.impl.BoardLocation;

public class DeployPieceHelper {
	private BoardLocation firstCoordinate;
	private BoardLocation secondCoordinate;
	private DeployPieceCounter dpc;
	
	public DeployPieceHelper(DeployPieceCounter dpc) {
		this.dpc = dpc;
	}
	
	public DeployPieceHelper() {
		this(new DeployPieceCounter());
	}
	
	public BoardLocation getFirstCoordinate() {
		return firstCoordinate;
	}

	public BoardLocation getSecondCoordinate() {
		return secondCoordinate;
	}
	
	public void setFirstCoordinate(BoardLocation firstCoordinate) {
		this.firstCoordinate = firstCoordinate;
	}

	public String deployPiece(BoardLocation newCoordinate, State state, DeployPieceCounter dpc) {
		this.dpc = dpc;
		if (firstCoordinate==null) {
			firstCoordinate = newCoordinate;
			String result = validateFirstCoordinate(state);
			return (result==null?"firstMoveOk"+firstCoordinate.getId():"firstMoveFailed");
		}
		secondCoordinate = newCoordinate;
		return validateCoordinates();
	}
	
	private String validateFirstCoordinate(State state) {
		String result = null;
		int locationIndex = -1;
		for (int i = 0; i < state.getBoard().getLocations().size(); i++)
			if (state.getBoard().getLocations().get(i).getId().equals(firstCoordinate.getId()))
				locationIndex = i;
		if (state.getBoard().getLocations().get(locationIndex).getPieces().size()!=0){
			firstCoordinate = null;
			result = "The first coordinate is busy!";
		}
		return result;
	}

	private String validateCoordinates() {
		String message = "";
		if (isNotDiagonally())
			message = "It is not legal to place a piece diagonally!";
		else if (isOutOfSizeBounds())
			message = "No piece has the given length!";
		else if (isNoSizeOfPieceLeftToDeploy())
			message = "No pieces of the current size left to deploy!";
		return message;
	}
	
	private boolean isNotDiagonally() {
		if (!firstCoordinate.getId().substring(0, 1).equals(secondCoordinate.getId().substring(0, 1)) && !firstCoordinate.getId().substring(1).equals(secondCoordinate.getId().substring(1)))
			return true;
		return false;
	}
	
	private boolean isOutOfSizeBounds() {
		int targetSize = calculatePieceSize();
		if (targetSize < 2 || targetSize > 5)
			return true;
		return false;
	}
	
	private boolean isNoSizeOfPieceLeftToDeploy() {
		int targetSize = calculatePieceSize();
		if (targetSize==5)
			if (dpc.getPiecesOfLengthFive()<1)
				return true;
		if (targetSize==4)
			if (dpc.getPiecesOfLengthFour()<1)
				return true;
		if (targetSize==3)
			if (dpc.getPiecesOfLengthThree()<1)
				return true;
		if (targetSize==2)
			if (dpc.getPiecesOfLengthTwo()<1)
				return true;
		return false;
	}
	
	private int calculatePieceSize() {
		int result = 0;
		if (firstCoordinate.getId().substring(0, 1).equals(secondCoordinate.getId().substring(0, 1)))
			result = Math.abs(Integer.parseInt(firstCoordinate.getId().substring(1)) - Integer.parseInt(secondCoordinate.getId().substring(1))) + 1;
		else
			result = Math.abs((int)firstCoordinate.getId().charAt(0) - (int)secondCoordinate.getId().charAt(0)) + 1;
		return result;
	}
}
