package backend;

import backend.actions.*;
import backend.undoable.MoveAction;
import backend.undoable.TurnIncrement;
import game.impl.Move;
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
        new MoveAction(state, move).execute();
    }

    public void reset(){
        new Reset(state).execute();
    }

    public void incrementTurn(){
        new TurnIncrement(state).execute();
    }
}
