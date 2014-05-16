package battleships.backend.actionhelpers;


import battleships.Settings;
import battleships.backend.State;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

import java.util.ArrayList;
import java.util.List;

public class ResetHelper {

    private State state;

    public ResetHelper(State state){
        this.state = state;
    }

    public void reset(){

    }

    public void resetPlayers(){
        List<Player> players = new ArrayList<>();

        Player playerOne = new Player(Settings.PLAYER_ONE_NAME, new ArrayList<GamePiece>());

        Player playerTwo = new Player(Settings.PLAYER_TWO_NAME, new ArrayList<GamePiece>());


    }


}
