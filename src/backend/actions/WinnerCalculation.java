package backend.actions;

import backend.State;
import game.impl.Player;

public class WinnerCalculation {

    private State state;

    public WinnerCalculation(State state){
        this.state = state;
    }

    public Player execute(){
        int playerOneScore = state.getPlayers().get(0).getPieces().size();
        int playerTwoScore = state.getPlayers().get(1).getPieces().size();

        if(playerOneScore > playerTwoScore)
            return state.getPlayers().get(0);
        else if(playerOneScore < playerTwoScore)
            return state.getPlayers().get(1);

        return null;
    }
}
