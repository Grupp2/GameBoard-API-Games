package backend;

import backend.actions.TurnIncrement;
import game.impl.Move;
import backend.actions.BoardUpdate;
import backend.actions.MoveValidation;
import backend.actions.Reset;
import backend.util.BoardParser;


public class ActionHandler {

    private State state;
    private OthelloGameFactory factory;


    public ActionHandler(State state, OthelloGameFactory factory){
        this.state = state;
        this.factory = factory;
    }

    public ActionHandler(State state){
        this(state, new OthelloGameFactory());
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
        new Reset(state, factory).execute();
    }

    public void incrementTurn(){
        new TurnIncrement(state).execute();
    }
}
