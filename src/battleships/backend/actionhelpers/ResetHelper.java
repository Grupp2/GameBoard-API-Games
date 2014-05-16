package battleships.backend.actionhelpers;


import battleships.Settings;
import battleships.backend.State;
import game.impl.Board;
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
        resetPlayers();
        resetBoard();
        resetMessage();
        resetLastPlayer();
        resetCurrentPlayer();
        resetIsDeployMode();
    }

    public void resetPlayers(){
        state.setPlayers(createPlayers());
    }

    public void resetBoard(){
        state.setBoard(new Board(createBoardLocations()));
    }

    public void resetMessage(){
        state.setMessage(createMessage());
    }

    public void resetLastPlayer(){
        state.setLastPlayer(null);
    }

    public void resetCurrentPlayer(){
        state.setCurrentPlayer(state.getPlayers().get(0));
    }

    public void resetIsDeployMode(){
        state.setIsDeployMode(true);
    }


    List<Player> createPlayers(){
        List<Player> players = new ArrayList<>();

        Player playerOne = new Player(Settings.PLAYER_ONE_NAME, new ArrayList<GamePiece>());
        Player playerTwo = new Player(Settings.PLAYER_TWO_NAME, new ArrayList<GamePiece>());

        players.add(playerOne);
        players.add(playerTwo);

        return players;
    }

    List<BoardLocation> createBoardLocations(){
        List<BoardLocation> locations = new ArrayList<>();

        for(int j = (int)'A'; j <= (int)'T'; j++)
            for(int i = 1; i <= 10; i++)
                locations.add(new BoardLocation(""+(char)j+i));

        return locations;
    }

    String createMessage(){
        return "";
    }

}
