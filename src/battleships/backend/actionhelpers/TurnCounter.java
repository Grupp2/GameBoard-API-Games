package battleships.backend.actionhelpers;

import battleships.backend.State;

public class TurnCounter {
    private int deployMovesRemaining = 20;
    private State state;
    
    public TurnCounter(State state) {
	    this.state = state;
    }
    
    public int getRemainingDeployMoves() {
	    return deployMovesRemaining;
    }
    
    public int decrementMoveCounter() {
        deployMovesRemaining--;

        if (deployMovesRemaining == 0)
            state.setIsDeployMode(false);
        return deployMovesRemaining;
    }
    
}
