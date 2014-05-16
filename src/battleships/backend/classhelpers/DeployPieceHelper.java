package battleships.backend.classhelpers;

import game.impl.BoardLocation;

public class DeployPieceHelper {
	private BoardLocation firstCoordinate;
	private BoardLocation secondCoordinate;
	private DeployPieceHolder dph;
	
	public DeployPieceHelper() {
		dph = new DeployPieceHolder();
	}
	
	public String bsDeployPiece(BoardLocation newCoordinate) {
		if (firstCoordinate==null) {
			firstCoordinate = newCoordinate;
			return null;
		}
		secondCoordinate = newCoordinate;
		String deployResult = doDeployValidation();
		return deployResult;
	}

	private String doDeployValidation() {
		String message = "";
		if (sameCoordinate())
			message = "Not a leagal piece!";
		else if (isNotDiagonally())
			message = "It is not leagal to place pieces diagonally";
		else if (isNoSizeOfPieceLeftToDeploy())
			message = "No pieces of the current size left to deploy!";
		return message;
	}
	
	private boolean sameCoordinate() {
		return firstCoordinate == secondCoordinate;
	}
	
	private boolean isNotDiagonally() {
		if (!firstCoordinate.getId().substring(0, 1).equals(secondCoordinate.getId().substring(0, 1)) && !firstCoordinate.getId().substring(1).equals(secondCoordinate.getId().substring(1)))
			return true;
		return false;
	}
	
	private boolean isNoSizeOfPieceLeftToDeploy() {
		
		return false;
	}
}
