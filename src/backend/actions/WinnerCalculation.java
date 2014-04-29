package backend.actions;

import backend.State;
import game.impl.Player;

public class WinnerCalculation {

    private State state;

    public WinnerCalculation(State state){
        this.state = state;
    }

    public Player execute(){
        int playerOneScore = getPlayerScore(state.getPlayers().get(0));
        int playerTwoScore = getPlayerScore(state.getPlayers().get(1));

        if(playerOneScore > playerTwoScore)
            return state.getPlayers().get(0);
        else if(playerOneScore < playerTwoScore)
            return state.getPlayers().get(1);

        return null;
    }

    private int getPlayerScore(Player player){
        return player.getPieces().size();
    }
}