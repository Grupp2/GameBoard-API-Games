package battleships.backend.actionhelpers;

import battleships.backend.State;
import battleships.backend.classhelpers.DeployMoveHelper;
import game.impl.Move;

public class DeployMoveValidationHelper implements MoveValidatable {
	private State state;
    private DeployMoveHelper moveHelper;
	
	public DeployMoveValidationHelper(State state, DeployMoveHelper moveHelper){
        this.state = state;
        this.moveHelper = moveHelper;
    }
	
	public DeployMoveValidationHelper(State state){
        this(state, new DeployMoveHelper(state));
    }

	@Override
	public boolean makeMoveValidation(Move move) {
		return false;
	}

}
