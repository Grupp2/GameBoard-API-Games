package battleships.backend.actionhelpers;

import battleships.backend.Settings;
import battleships.backend.State;
import battleships.backend.classhelpers.BoardHelper;
import battleships.backend.classhelpers.MoveHelper;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;

import java.util.List;

public class DeployMoveExecutor implements MoveExecutor{

    private State state;
    private MoveHelper moveHelper;
    private TurnCounter turnCounter;

    public DeployMoveExecutor(State state, MoveHelper moveHelper, TurnCounter turnCounter){
        this.state = state;
        this.moveHelper = moveHelper;
        this.turnCounter = turnCounter;
    }

    public DeployMoveExecutor(State state, TurnCounter turnCounter){
        this(state, new MoveHelper(state), turnCounter);
    }


    @Override
    public void executeMove(Move move) {

        if(moveHelper.isDeployStartMove()){
            move.getDestination().setPiece(new GamePiece(Settings.DEPLOY_PIECE_ID));
        }
        else{
            BoardLocation startDeployLocation = moveHelper.getDeployStartLocation();
            List<BoardLocation> locationsToDeployAt = moveHelper.getLocationsToDeployShipAtFromLocations(startDeployLocation, move.getDestination());

            GamePiece theShipToDeploy = new GamePiece(Settings.SHIP_ID+"?"+locationsToDeployAt.size());

            for(int i = 0; i < locationsToDeployAt.size(); i++)
                locationsToDeployAt.get(i).setPiece(theShipToDeploy);

            turnCounter.decrementMoveCounter();
        }
    }
}
