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

        if(noLastPlayerSet()) {
            List<Player> players = state.getPlayers();

            if (players.indexOf(state.getCurrentPlayer()) == 0)
                state.setLastPlayer(players.get(1));
            else
                state.setLastPlayer(players.get(0));
        }

        swapCurrentAndLastPlayer();
    }


    private boolean noLastPlayerSet(){
        return state.getLastPlayer() == null;
    }

    private void swapCurrentAndLastPlayer(){
        Player newCurrentPlayer = state.getLastPlayer();
        state.setLastPlayer(state.getCurrentPlayer());
        state.setCurrentPlayer(newCurrentPlayer);
    }
}
