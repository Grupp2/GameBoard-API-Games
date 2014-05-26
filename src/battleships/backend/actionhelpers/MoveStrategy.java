package battleships.backend.actionhelpers;

import battleships.backend.State;

public class MoveStrategy {
    private State state;

    private DeployMoveValidationHelper deployMoveValidationHelper;
    private NormalMoveValidationHelper normalMoveValidationHelper;

    private DeployMoveExecutor deployMoveExecutor;
    private NormalMoveExecutor normalMoveExecutor;

    public MoveStrategy(State state, DeployMoveValidationHelper deployMoveValidationHelper, NormalMoveValidationHelper normalMoveValidationHelper, DeployMoveExecutor deployMoveExecutor, NormalMoveExecutor normalMoveExecutor){
        this.state = state;

        this.deployMoveValidationHelper = deployMoveValidationHelper;
        this.normalMoveValidationHelper = normalMoveValidationHelper;

        this.deployMoveExecutor = deployMoveExecutor;
        this.normalMoveExecutor = normalMoveExecutor;
    }


    public MoveStrategy(State state, TurnCounter turnCounter) {
        this(state, new DeployMoveValidationHelper(state), new NormalMoveValidationHelper(state), new DeployMoveExecutor(state, turnCounter), new NormalMoveExecutor(state));
    }

    public MoveValidator getMoveValidator() {
        if(state.isDeployMode())
            return this.deployMoveValidationHelper;

        return this.normalMoveValidationHelper;
    }
    
    public MoveExecutor getMoveExecutor() {
    	if(state.isDeployMode())
            return this.deployMoveExecutor;

        return this.normalMoveExecutor;
    }
}
