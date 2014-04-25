package backend;

import backend.actions.*;
import game.impl.Move;
import backend.util.BoardParser;
import game.impl.Player;


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

    public Player calculateWinner(){
        return new WinnerCalculation(state).execute();
    }

    public boolean hasEndedCheck(){
        return new HasEndedControl(state).execute();
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
        new Reset(state).execute();
    }

    public void incrementTurn(){
        new TurnIncrement(state).execute();
    }
}
