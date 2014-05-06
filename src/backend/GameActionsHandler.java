package backend;

import backend.actionhelpers.WinnerCalculationHelper;
import backend.undoableactions.MoveAction;
import backend.undoableactions.UndoableAction;
import backend.actionhelpers.GameoverCheckHelper;
import backend.actionhelpers.MoveValidator;
import backend.actionhelpers.ResetHelper;
import game.impl.Move;
import game.impl.Player;


public class GameActionsHandler {

    private State state;

    public GameActionsHandler(State state){
        this.state = state;
    }

    public Player calculateWinner(){
        WinnerCalculationHelper winnerCalc = new WinnerCalculationHelper(state);

        return winnerCalc.getWinner();
    }

    public boolean hasEndedCheck(){
        GameoverCheckHelper gameEndHelper = new GameoverCheckHelper(state);

        if(gameEndHelper.isBoardFull())
            return true;

        if(gameEndHelper.doesAnyPlayerNotHaveAnyPiecesLeft())
            return true;

        if(gameEndHelper.isCurrentPlayerOutOfValidMoves())
            return true;

        return false;
    }

    public boolean validateMove(Move move){
        MoveValidator moveValidator = new MoveValidator(state, move);

        if(moveValidator.isMoveNull()){
            state.setMessage("");
            return false;
        }

        if(!moveValidator.isPlayersTurnToMove()){
            state.setMessage("It's not your turn!");
            return false;
        }

        if(!moveValidator.doesDestinationExist()){
            state.setMessage("Invalid location!");
            return false;
        }

        if(!moveValidator.isDestinationEmpty()){
            state.setMessage("There is already a piece in that location!");
            return false;
        }

        if(moveValidator.isTryingToMovePieceAlreadyPlaced()){
            state.setMessage("You cannot move a piece already placed on the board.");
            return false;
        }

        if(!moveValidator.isValidOthelloMove()){
            state.setMessage("You have to put your piece at a valid location!");
            return false;
        }

        state.setMessage("");
        return true;
    }

    public void executeMove(Move move){
        UndoableAction moveAction = new MoveAction(state, move);
        moveAction.execute();
        state.pushActionOnUndoStack(moveAction);
    }

    public void reset(){
        ResetHelper resetHelper = new ResetHelper(state);

        resetHelper.resetPlayers();
        resetHelper.resetBoard();
        resetHelper.resetTurn();
        resetHelper.resetActionsStack();
        resetHelper.resetMessage();

        resetHelper.setStartingPositions();
    }

}
