package backend;

import backend.actionhelpers.GameOverCheckHelper;
import backend.actionhelpers.MoveValidationHelper;
import backend.actionhelpers.WinnerCalculationHelper;
import backend.undoableactions.MoveAction;
import backend.undoableactions.UndoableAction;
import backend.actionhelpers.ResetHelper;
import game.impl.Move;
import game.impl.Player;


public class GameActionsHandler {

    private State state;
    private MoveValidationHelper moveValidationHelper;
    private GameOverCheckHelper gameEndHelper;
    private WinnerCalculationHelper winnerCalc;

    public GameActionsHandler(State state, MoveValidationHelper moveValidationHelper, GameOverCheckHelper gameEndHelper, WinnerCalculationHelper winnerCalc){
        this.state = state;
        this.moveValidationHelper = moveValidationHelper;
        this.gameEndHelper = gameEndHelper;
        this.winnerCalc = winnerCalc;
    }

    public GameActionsHandler(State state){
        this(state, new MoveValidationHelper(state), new GameOverCheckHelper(state), new WinnerCalculationHelper(state));
    }

    public Player calculateWinner(){
        return winnerCalc.makeWinnerCalculation();
    }

    public boolean hasEndedCheck(){
        return gameEndHelper.makeGameOverCheck();
    }

    public boolean validateMove(Move move){
        return moveValidationHelper.makeMoveValidation(move);
    }

    public void executeMove(Move move){
        UndoableAction moveAction = new MoveAction(state, move);
        moveAction.execute();
        state.pushActionOnUndoStack(moveAction);
    }

    public void undo(){
        if(state.getLastExecutedActionIndex() < 0)
            throw new RuntimeException("No more actions to undo!");

        state.getUndoableActionsStack().get(state.getLastExecutedActionIndex()).undo();

        state.setLastExecutedActionIndex(state.getLastExecutedActionIndex()-1);
    }

    public void redo(){
        if(state.getLastExecutedActionIndex() >= state.getUndoableActionsStack().size()-1)
            throw new RuntimeException("No more actions to redo!");

        state.setLastExecutedActionIndex(state.getLastExecutedActionIndex()+1);

        state.getUndoableActionsStack().get(state.getLastExecutedActionIndex()).execute();
    }

    public void reset(){
        ResetHelper resetHelper = new ResetHelper(state);

        resetHelper.doResetAction();
    }

}
