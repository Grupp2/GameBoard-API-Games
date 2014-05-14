package othellobackend.actionhelpers;

import othellobackend.State;
import othellobackend.classhelpers.PlayerHelper;
import game.impl.Player;

public class WinnerCalculationHelper {
    private PlayerHelper playerHelper;

    public WinnerCalculationHelper(PlayerHelper playerHelper){
        this.playerHelper = playerHelper;
    }

    public WinnerCalculationHelper(State state){
        this(new PlayerHelper(state));
    }

    public Player makeWinnerCalculation(){
        int playerOneScore = playerHelper.getPlayerScore(playerHelper.getPlayerOne());
        int playerTwoScore = playerHelper.getPlayerScore(playerHelper.getPlayerTwo());

        if(playerOneScore > playerTwoScore)
            return playerHelper.getPlayerOne();

        else if(playerOneScore < playerTwoScore)
            return playerHelper.getPlayerTwo();

        return new Player("Draw", null);
    }
}
