package battleships.backend.actionhelpers;

import battleships.backend.State;
import game.impl.Move;

public class NormalMoveValidationHelper implements MoveValidatable {
    private State state;
    
//    public NormalMoveValidationHelper(State state, ) {
//    	
//    }
    
    public NormalMoveValidationHelper(State state) {
        this.state = state;
    }
	@Override
	public boolean makeMoveValidation(Move move) {
		return false;
	}

}
