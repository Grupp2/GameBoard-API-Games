package impl;

import game.impl.Move;
import impl.Actions.BoardUpdate;
import impl.Actions.MoveValidation;
import impl.Actions.Reset;
import impl.util.BoardParser;
import impl.util.GameRules;
import impl.util.TurnCounter;


public class ActionHandler {

    private State state;
    private OthelloGameFactory factory;

    public ActionHandler(State state, OthelloGameFactory factory){
        this.state = state;
        this.factory = factory;
    }

    public boolean validateMove(Move move){
        return new MoveValidation(state, move).execute();
    }

    public void executeMove(Move move){
        move.execute();
        state.getCurrentPlayer().getPieces().add(move.getPiece());

        new BoardUpdate(state, new BoardParser(state.getBoard(), move.getDestination())).execute();

        incrementTurn();
    }

    public void reset(){
        new Reset(state, factory);
    }

    public void incrementTurn(){
        state.getTurnCounter().increment();
    }
}
