package battleships.backend.classhelpers;

import game.impl.BoardLocation;

public class DeployPieceHelper {
	private BoardLocation firstCoordinate;
	private BoardLocation secondCoordinate;
	private DeployPieceHolder dph;
	
	public DeployPieceHelper(DeployPieceHolder dph) {
		this.dph = dph;
	}
	
	public DeployPieceHelper() {
		this(new DeployPieceHolder());
	}
	
	public String deployPiece(BoardLocation newCoordinate) {
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
	
	private int calculatePieceSize() {
		int result = 0;
		if (firstCoordinate.getId().substring(0, 1).equals(secondCoordinate.getId().substring(0, 1)))
			result = Math.abs(Integer.parseInt(firstCoordinate.getId().substring(1)) - Integer.parseInt(secondCoordinate.getId().substring(1)));
		else
			result = Math.abs((int)firstCoordinate.getId().charAt(0) - (int)secondCoordinate.getId().charAt(0));
		return result;
	}
}
