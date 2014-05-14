package othellobackend.classhelpers;

import othellobackend.Settings;
import othellobackend.State;
import game.impl.Player;

public class PlayerHelper {

    private State state;

    public PlayerHelper(State state){
        this.state = state;
    }


    public int getPlayerScore(Player player){
        return player.getPieces().size();
    }

    public Player getPlayerOne(){
        return state.getPlayers().get(Settings.PLAYER_ONE_INDEX);
    }

    public Player getPlayerTwo(){
        return state.getPlayers().get(Settings.PLAYER_TWO_INDEX);
    }
}
