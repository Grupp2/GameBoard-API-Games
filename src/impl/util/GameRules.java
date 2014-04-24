package impl.util;

import game.impl.*;

import java.util.List;


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
        return location == null ? null : location.getPiece() == null;
    }

    public static int getPlayerScore(Player player){
        return player.getPieces().size();
    }

    public static boolean isLocationNextToPiece(Board board, BoardLocation location){
        char row = location.getId().charAt(0);
        char col = location.getId().charAt(1);

        for(int i = -1; i <= 1; i++){
            if(!isLocationEmpty(getLocationById(board, ""+(char)(row+1)+(char)(col+i))))
                return true;

            if(!isLocationEmpty(getLocationById(board, ""+(char)(row-1)+(char)(col+i))))
                return true;
        }

        if(!isLocationEmpty(getLocationById(board, ""+(row)+(char)(col-1))))
            return true;

        if(!isLocationEmpty(getLocationById(board, ""+(row)+(char)(col+1))))
            return true;

        return false;
    }

    public static BoardLocation getLocationById(Board board, String id){
        List<BoardLocation> locations = board.getLocations();

        for(int i = 0; i < locations.size(); i++)
            if(locations.get(i).getId().equals(id))
                return locations.get(i);

        return null;
    }

}
