package battleships.backend.classhelpers;

public class DeployPieceCounter {
	private boolean piecesLeftToDeploy;
	private int piecesOfLengthTwo;
	private int piecesOfLengthThree;
	private int piecesOfLengthFour;
	private int piecesOfLengthFive;
	
	public DeployPieceCounter() {
		this(true, 4, 3, 2, 1);
	}
	
	public DeployPieceCounter(boolean piecesLeftToDeploy, int piecesOfLengthTwo, int piecesOfLengthThree, int piecesOfLengthFour, int piecesOfLengthFive) {
		this.piecesLeftToDeploy = piecesLeftToDeploy;
		this.piecesOfLengthTwo = piecesOfLengthTwo;
		this.piecesOfLengthThree = piecesOfLengthThree;
		this.piecesOfLengthFour = piecesOfLengthFour;
		this.piecesOfLengthFive = piecesOfLengthFive;
	}

	public boolean hasPiecesLeftToDeploy() {
		return piecesLeftToDeploy;
	}
	
	public boolean deployPieceOfLenghtTwo() {
		if (piecesOfLengthTwo>0) {
			piecesOfLengthTwo--;
			return true;
		}
		return false;
	}
	
	public boolean deployPieceOfLenghtThree() {
		if (piecesOfLengthThree>0) {
			piecesOfLengthThree--;
			return true;
		}
		return false;
	}
	
	public boolean deployPieceOfLenghtFour() {
		if (piecesOfLengthFour>0) {
			piecesOfLengthFour--;
			return true;
		}
		return false;
	}
	
	public boolean deployPieceOfLenghtFive() {
		if (piecesOfLengthFive>0) {
			piecesOfLengthFive--;
			return true;
		}
		return false;
	}
}
