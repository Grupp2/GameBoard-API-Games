package battleships.backend.actionhelpers;

import battleships.backend.State;

/**
 * Created by hugg on 2014-05-20.
 */
public class MoveStrategy {
    private State state;

    public MoveStrategy(State state) {
        this.state = state;
    }

    public MoveValidatable getMoveValidator() {
        if (state.isDeployMode()) {
            return new DeployMoveValidationHelper(state);
        } else {
            return new NormalMoveValidationHelper(state);
        }
    }
    
    public MoveExecutable getMoveExecutor() {
    	if (state.isDeployMode())
    		return new DeployMoveExecutor(state);
    	else
    		return new NormalMoveExecutor(state);
    }
}
