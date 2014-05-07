package backend.actionhelpers;

import backend.State;
import backend.classhelpers.PlayerHelper;
import game.impl.Player;

public class WinnerCalculationHelper {

    private State state;
    private PlayerHelper playerHelper;

    public WinnerCalculationHelper(State state, PlayerHelper playerHelper){
        this.state = state;
        this.playerHelper = playerHelper;
    }

    public WinnerCalculationHelper(State state){
        this(state, new PlayerHelper(state));
    }


    public Player makeWinnerCalculation(){
        int playerOneScore = playerHelper.getPlayerScore(playerHelper.getPlayerOne());
        int playerTwoScore = playerHelper.getPlayerScore(playerHelper.getPlayerTwo());

        if(playerOneScore > playerTwoScore)
            return playerHelper.getPlayerOne();

        else if(playerOneScore < playerTwoScore)
            return playerHelper.getPlayerTwo();

        return null;
    }
}
