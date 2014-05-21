package battleships.backend.actionhelpers;

import battleships.backend.State;

/**
 * Created by hugg on 2014-05-20.
 */
public class MoveStrategy {
    private State state;
    private DeployMoveValidationHelper deployMoveValidationHelper;
    private NormalMoveValidationHelper normalMoveValidationHelper;

    private DeployMoveExecutor deployMoveExecutor;
    private NormalMoveExecutor normalMoveExecutor;

    public MoveStrategy(State state) {
        this.state = state;
    }

    public MoveValidatable getMoveValidator() {
        if (state.isDeployMode()) {
            if (deployMoveValidationHelper == null)
                return (deployMoveValidationHelper = new DeployMoveValidationHelper(state));
            else
                return deployMoveValidationHelper;
        } else {
            if (normalMoveValidationHelper == null)
                return (normalMoveValidationHelper = new NormalMoveValidationHelper(state));
            else
                return normalMoveValidationHelper;
        }
    }
    
    public MoveExecutable getMoveExecutor() {
    	if (state.isDeployMode()) {
            if (deployMoveExecutor == null)
                return (deployMoveExecutor = new DeployMoveExecutor(state));
            else
                return deployMoveExecutor;
        } else {
            if (normalMoveExecutor == null)
                return (normalMoveExecutor = new NormalMoveExecutor(state));
            else
                return normalMoveExecutor;
        }
    }
}
