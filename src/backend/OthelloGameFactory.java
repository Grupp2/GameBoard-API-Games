package backend;

import java.util.ArrayList;
import java.util.List;

import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

public class OthelloGameFactory {

    public List<Player> createPlayers(){
        List<Player> players = new ArrayList<Player>();

        players.add(new Player("P1", makePlayerOneGamePieces()));
        players.add(new Player("P2", makePlayerTwoGamePieces()));

        return players;
    }

    public Board createBoard(){
        return new Board(makeBoardLocations());
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
