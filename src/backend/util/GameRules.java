package backend.util;

import game.impl.*;

import java.util.List;


public class GameRules {

    public static boolean isPlayerOnePiece(GamePiece piece){
        return piece.getId().equals("O");
    }

    public static boolean isPlayerTwoPiece(GamePiece piece){
        return piece.getId().equals("X");
    }

    public static boolean isLocationEmpty(BoardLocation location){
        return location == null || location.getPiece() == null;
    }

    public static boolean isLocationNextToPiece(Board board, BoardLocation location){
        char row = location.getId().charAt(0);
        char col = location.getId().charAt(1);
        String id;

        BoardLocation tmp;
        for(int i = -1; i <= 1; i++){

            id = ""+(char)(row+1)+(char)(col+i);

            tmp = getLocationById(board, id);
            if(tmp != null)
                if(!isLocationEmpty(tmp))
                    return true;



            id = ""+(char)(row-1)+(char)(col+i);

            tmp = getLocationById(board, id);
            if(tmp != null)
                if(!isLocationEmpty(tmp))
                    return true;


        }

        tmp = getLocationById(board, ""+(row)+(char)(col-1));
        if(tmp != null && !isLocationEmpty(tmp))
            return true;

        tmp = getLocationById(board, ""+(row)+(char)(col+1));
        if(tmp != null && !isLocationEmpty(tmp))
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
