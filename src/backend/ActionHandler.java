package backend;

import backend.actions.*;
import game.impl.Move;
import backend.util.BoardParser;
import game.impl.Player;


public class ActionHandler {

    private State state;

    public ActionHandler(State state){
        this.state = state;
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
        state.getPlayers().get(state.getCurrentPlayerIndex()).getPieces().add(move.getPiece());

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
