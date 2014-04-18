package impl;

import game.api.GameState;
import game.impl.*;

import java.util.List;

/**
 * @author erik
 */
public class GameRules {

    public static boolean isBoardFull(Board board){
        List<BoardLocation> locations = board.getLocations();

        for(int i = 0; i < locations.size(); i++)
            if(isLocationEmpty(locations.get(i)))
                return false;

        return true;
    }

    public static boolean isPlayerOnePiece(GamePiece piece){
        return piece.getId().equals("O");
    }

    public static boolean isPlayerTwoPiece(GamePiece piece){
        return piece.getId().equals("X");
    }

    public static boolean isLocationEmpty(BoardLocation location){
        return location.getPiece() == null;
    }

    public static int getPlayerScore(Player player){
        return player.getPieces().size();
    }


}
