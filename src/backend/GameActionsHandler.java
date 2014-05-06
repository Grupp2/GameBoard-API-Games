package backend;

import backend.actionhelpers.MoveValidationHelper;
import backend.actionhelpers.WinnerCalculationHelper;
import backend.undoableactions.MoveAction;
import backend.undoableactions.UndoableAction;
import backend.actionhelpers.GameoverCheckHelper;
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
        MoveValidationHelper moveValidationHelper = new MoveValidationHelper(state, move);

        if(moveValidationHelper.isRequestForRepublish()){
            state.setMessage("");
            return false;
        }

        if(!moveValidationHelper.isPlayersTurnToMove()){
            state.setMessage("It's not your turn!");
            return false;
        }

        if(!moveValidationHelper.doesDestinationExist()){
            state.setMessage("Invalid location!");
            return false;
        }

        if(!moveValidationHelper.isDestinationEmpty()){
            state.setMessage("There is already a piece in that location!");
            return false;
        }

        if(moveValidationHelper.isTryingToMovePieceAlreadyPlaced()){
            state.setMessage("You cannot move a piece already placed on the board.");
            return false;
        }

        if(!moveValidationHelper.isValidOthelloMove()){
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

    public void undo(){
        if(state.getLastExecutedActionIndex() < 0)
            throw new RuntimeException("No more undoableActionsStack to undo!");

        state.getUndoableActionsStack().get(state.getLastExecutedActionIndex()).undo();

        state.setLastExecutedActionIndex(state.getLastExecutedActionIndex()-1);
    }

    public void redo(){
        if(state.getLastExecutedActionIndex() >= state.getUndoableActionsStack().size()-1)
            throw new RuntimeException("No more undoableActionsStack to redo!");

        state.setLastExecutedActionIndex(state.getLastExecutedActionIndex()+1);

        state.getUndoableActionsStack().get(state.getLastExecutedActionIndex()).execute();
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
