package battleships.backend.actionhelpers;

import battleships.backend.State;
import battleships.backend.classhelpers.DeployBoardHelper;
import battleships.backend.classhelpers.DeployPieceCounter;
import battleships.backend.classhelpers.DeployPieceHelper;
import game.impl.Move;

public class DeployMoveValidationHelper implements MoveValidateable {
	private State state;
    private DeployBoardHelper moveHelper;
    private DeployPieceHelper pieceHelper;
    private DeployPieceCounter dpc;
	
	public DeployMoveValidationHelper(State state, DeployBoardHelper moveHelper, DeployPieceHelper pieceHelper){
        this.state = state;
        this.moveHelper = moveHelper;
        this.pieceHelper = pieceHelper;
        this.dpc = new DeployPieceCounter();
    }
	
	public DeployMoveValidationHelper(State state){
        this(state, new DeployBoardHelper(), new DeployPieceHelper());
    }
	
	private String validatePiece(Move move) {
		return pieceHelper.deployPiece(move.getDestination());
	}
	
	private String validateBoard() {
		 return moveHelper.checkPieceLocations(pieceHelper.getFirstCoordinate(), pieceHelper.getSecondCoordinate(), state);
	}
	
	private void switchPlayer() {
		if (!dpc.hasPiecesLeftToDeploy())
			dpc = new DeployPieceCounter();
	}

	@Override
	public boolean makeMoveValidation(Move move) {
		if(isRequestForRepublish(move)){
            state.setMessage("");
            return false;
        }
		state.setMessage(validatePiece(move));
		if (!state.getMessage().equals(""))
			return false;
		
		state.setMessage(validateBoard());
		if (!state.getMessage().equals(""))
			return false;
		
        state.setMessage("");
        return true;
	}

	public boolean isRequestForRepublish(Move move){
        return move == null;
    }
}
