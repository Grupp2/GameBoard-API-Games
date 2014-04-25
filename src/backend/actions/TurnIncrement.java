package backend.actions;


import backend.State;
import game.impl.Player;

import java.util.List;

public class TurnIncrement {

    private State state;

    public TurnIncrement(State state){
        this.state = state;
    }

    public void execute(){

        if(noLastPlayerSet()){
            if(state.getCurrentPlayerIndex() == 0)
                state.setLastPlayerIndex(1);
            else
                state.setLastPlayerIndex(0);
        }

        swapCurrentAndLastPlayer();
    }


    private boolean noLastPlayerSet(){
        return state.getLastPlayerIndex() == -1;
    }

    private void swapCurrentAndLastPlayer(){
        int newCurrentPlayer = state.getLastPlayerIndex();
        state.setLastPlayerIndex(state.getCurrentPlayerIndex());
        state.setCurrentPlayerIndex(newCurrentPlayer);
    }
}
