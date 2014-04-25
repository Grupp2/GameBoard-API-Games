package backend.undoable;


import backend.State;
import game.impl.Player;

import java.util.List;

public class TurnIncrement implements UndoableAction{

    private State state;

    private Player oldCurrentPlayer;
    private Player oldLastPlayer;

    public TurnIncrement(State state){
        this.state = state;
    }


    public void execute(){

        oldCurrentPlayer = state.getCurrentPlayer();
        oldLastPlayer = state.getLastPlayer();

        if(!isLastPlayerSet()) {
            List<Player> players = state.getPlayers();

            if (players.indexOf(state.getCurrentPlayer()) == 0)
                state.setLastPlayer(players.get(1));
            else
                state.setLastPlayer(players.get(0));
        }

        swapCurrentAndLastPlayer();
    }

    public void undo(){
        state.setLastPlayer(oldLastPlayer);
        state.setCurrentPlayer(oldCurrentPlayer);
    }

    public String getName(){
        return "Change of Turn";
    }


    private boolean isLastPlayerSet(){
        return state.getLastPlayer() != null;
    }

    private void swapCurrentAndLastPlayer(){
        Player newCurrentPlayer = state.getLastPlayer();
        state.setLastPlayer(state.getCurrentPlayer());
        state.setCurrentPlayer(newCurrentPlayer);
    }
}
