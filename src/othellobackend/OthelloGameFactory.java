package othellobackend;

import java.util.ArrayList;
import java.util.List;

import othellobackend.undoableactions.UndoableAction;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

public class OthelloGameFactory {

    public static final int DEFAULT_ACTION_INDEX = -1;

    public static final String DEFAULT_MESSAGE = "";


    public List<Player> createPlayers(){
        List<Player> players = new ArrayList<Player>();

        players.add(Settings.PLAYER_ONE_INDEX, new Player(Settings.PLAYER_ONE_NAME, makePlayerOneGamePieces()));
        players.add(Settings.PLAYER_TWO_INDEX, new Player(Settings.PLAYER_TWO_NAME, makePlayerTwoGamePieces()));

        return players;
    }

    public Board createBoard(){
        return new Board(makeBoardLocations());
    }

    public List<UndoableAction> createUndoableActionStack(){
        return new ArrayList<UndoableAction>();
    }

    public int createLastExecutedActionIndex(){
        return DEFAULT_ACTION_INDEX;
    }

    public String createStateMessage(){
        return DEFAULT_MESSAGE;
    }

    public GamePiece createPlayerOnePiece(){
        return new GamePiece(Settings.PLAYER_ONE_PIECE_ID);
    }

    public GamePiece createPlayerTwoPiece(){
        return new GamePiece(Settings.PLAYER_TWO_PIECE_ID);
    }


    private List<GamePiece> makePlayerOneGamePieces(){
        List<GamePiece> list = new ArrayList<GamePiece>();

        return list;
    }

    private List<GamePiece> makePlayerTwoGamePieces(){
        List<GamePiece> list = new ArrayList<GamePiece>();

        return list;
    }

    private List<BoardLocation> makeBoardLocations(){
        List<BoardLocation> list = new ArrayList<BoardLocation>();

        for(int j = (int)'A'; j <= (int)'H'; j++)
            for(int i = 1; i <= 8; i++)
                list.add(new BoardLocation(""+(char)j+i));

        return list;
    }
}
