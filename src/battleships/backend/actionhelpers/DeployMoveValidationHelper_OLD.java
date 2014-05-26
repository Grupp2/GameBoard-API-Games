package battleships.backend.actionhelpers;

import battleships.backend.State;
import battleships.backend.classhelpers.DeployBoardHelper;
import battleships.backend.classhelpers.DeployPieceCounter;
import battleships.backend.classhelpers.DeployPieceHelper;
import game.impl.Move;

public class DeployMoveValidationHelper_OLD implements MoveValidator {

	private State state;
    private DeployBoardHelper moveHelper;
    private DeployPieceHelper pieceHelper;
    private DeployPieceCounter deployPieceCounter;
	
	public DeployMoveValidationHelper_OLD(State state, DeployBoardHelper moveHelper, DeployPieceHelper pieceHelper){
        this.state = state;
        this.moveHelper = moveHelper;
        this.pieceHelper = pieceHelper;
        this.deployPieceCounter = new DeployPieceCounter();
    }
	
	public DeployMoveValidationHelper_OLD(State state){
        this(state, new DeployBoardHelper(), new DeployPieceHelper());
    }

    @Override
    public boolean makeMoveValidation(Move move/*, Move firstDeployMove*/) {
        Move firstDeployMove =      null;
        if (firstDeployMove==null)
            pieceHelper.setFirstCoordinate(null);

        if(isRequestForRepublish(move)){
            state.setMessage("");
            return false;
        }

        checkForPlayerSwitch();

        state.setMessage(validatePiece(move));
        if (state.getMessage().equals("firstMoveFailed") || !state.getMessage().equals(""))
            return false;

        state.setMessage(validateBoard());
        if (!state.getMessage().equals(""))
            return false;

        deployValid();
        state.setMessage("");
        return true;
    }


	private String validatePiece(Move move) {
		return pieceHelper.deployPiece(move.getDestination(), state, deployPieceCounter);
	}
	
	private String validateBoard() {
		 return moveHelper.checkPieceLocations(pieceHelper.getFirstCoordinate(), pieceHelper.getSecondCoordinate(), state);
	}
	
	private void checkForPlayerSwitch() {
		if (!deployPieceCounter.hasPiecesLeftToDeploy())
			deployPieceCounter = new DeployPieceCounter();
	}
	
	private void deployValid() {
		int pieceSize = moveHelper.getPieceLocationArraySize();
		if (pieceSize==2)
			deployPieceCounter.deployPieceOfLenghtTwo();
		else if (pieceSize==3)
			deployPieceCounter.deployPieceOfLenghtThree();
		else if (pieceSize==4)
			deployPieceCounter.deployPieceOfLenghtFour();
		else 
			deployPieceCounter.deployPieceOfLenghtFive();
	}



	public boolean isRequestForRepublish(Move move){
        return move == null;
    }
}
