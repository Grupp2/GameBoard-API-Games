package battleships.backend.classhelpers;

public class DeployPieceCounter {

	private boolean piecesLeftToDeploy;
	private int piecesOfLenghtTwo;
	private int piecesOfLenghtThree;
	private int piecesOfLenghtFour;
	private int piecesOfLenghtFive;
	private int totalPiecesToDeploy;
	
	public DeployPieceCounter() {
		this(true, 4, 3, 2, 1);
	}
	
	public DeployPieceCounter(boolean piecesLeftToDeploy, int piecesOfLengthTwo, int piecesOfLengthThree, int piecesOfLengthFour, int piecesOfLengthFive) {
		this.piecesLeftToDeploy = piecesLeftToDeploy;
		this.piecesOfLenghtTwo = piecesOfLengthTwo;
		this.piecesOfLenghtThree = piecesOfLengthThree;
		this.piecesOfLenghtFour = piecesOfLengthFour;
		this.piecesOfLenghtFive = piecesOfLengthFive;
		this.totalPiecesToDeploy = piecesOfLengthTwo + piecesOfLengthThree + piecesOfLengthFour + piecesOfLengthFive;
	}


	public boolean hasPiecesLeftToDeploy() {
		return piecesLeftToDeploy;
	}
	
	public boolean deployPieceOfLenghtTwo() {
		if (piecesOfLenghtTwo>0) {
			piecesOfLenghtTwo--;
			decreaseTotalPieces();
			return true;
		}
		return false;
	}
	
	public boolean deployPieceOfLenghtThree() {
		if (piecesOfLenghtThree>0) {
			piecesOfLenghtThree--;
			decreaseTotalPieces();
			return true;
		}
		return false;
	}
	
	public boolean deployPieceOfLenghtFour() {
		if (piecesOfLenghtFour>0) {
			piecesOfLenghtFour--;
			decreaseTotalPieces();
			return true;
		}
		return false;
	}
	
	public boolean deployPieceOfLenghtFive() {
		if (piecesOfLenghtFive>0) {
			piecesOfLenghtFive--;
			decreaseTotalPieces();
			return true;
		}
		return false;
	}

    public void decreaseTotalPieces() {
        this.totalPiecesToDeploy--;
        if (totalPiecesToDeploy==0)
            piecesLeftToDeploy = false;
    }

	public int getPiecesOfLengthTwo() {
		return piecesOfLenghtTwo;
	}

	public int getPiecesOfLengthThree() {
		return piecesOfLenghtThree;
	}

	public int getPiecesOfLengthFour() {
		return piecesOfLenghtFour;
	}

	public int getPiecesOfLengthFive() {
		return piecesOfLenghtFive;
	}
}
