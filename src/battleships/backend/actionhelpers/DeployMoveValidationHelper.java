package battleships.backend.actionhelpers;

import battleships.backend.State;
import battleships.backend.classhelpers.MoveHelper;
import game.impl.BoardLocation;
import game.impl.Move;

import java.util.List;

public class DeployMoveValidationHelper implements MoveValidator{

    private State state;
    private MoveHelper moveHelper;

    public DeployMoveValidationHelper(State state, MoveHelper moveHelper){
        this.state = state;
        this.moveHelper = moveHelper;
    }

    public DeployMoveValidationHelper(State state){
        this(state, new MoveHelper(state));
    }


    @Override
    public boolean makeMoveValidation(Move move){

        if(moveHelper.isDeployStartMove()){

            if(!moveHelper.isLocationEmpty(move.getDestination())){
                state.setMessage("There is already a ship in that location");
                return false;
            }
        }
        else{

            if(moveHelper.isPieceDeployedDiagonally(move)){
                state.setMessage("A ship cannot be placed diagonally");
                moveHelper.getDeployStartLocation().setPiece(null);
                return false;
            }

            List<BoardLocation> locationsToCheck = moveHelper.getLocationsToDeployShipAtFromLocations(moveHelper.getDeployStartLocation(), move.getDestination());
            int shipSize = locationsToCheck.size();

            if(moveHelper.doesAnyOfTheseLocationsHaveAShipOnThem(locationsToCheck)){
                state.setMessage("Ships cannot overlap each other");
                moveHelper.getDeployStartLocation().setPiece(null);
                return false;
            }

            if(!moveHelper.isValidLengthOfShip(shipSize)){
                state.setMessage("Ships are not allowed to have a length of "+shipSize);
                moveHelper.getDeployStartLocation().setPiece(null);
                return false;
            }

            if(!moveHelper.hasShipOfLengthLeftToDeploy(shipSize)){
                state.setMessage("You don't have any ships of length "+shipSize+" left to deploy");
                moveHelper.getDeployStartLocation().setPiece(null);
                return false;
            }
        }

        state.setMessage("");
        return true;
    }
}
