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

        List<BoardLocation> locations = board.getLocations();

        char row = location.getId().charAt(0);
        char col = location.getId().charAt(1);

        for(int i = -1; i <= 1; i++){
            if(!isLocationEmpty(getLocationById(board, ""+(row+1)+(col+i))))
                return true;

            if(!isLocationEmpty(getLocationById(board, ""+(row-1)+(col+i))))
                return true;
        }

        if(!isLocationEmpty(getLocationById(board, ""+(row)+(col-1))))
            return true;

        if(!isLocationEmpty(getLocationById(board, ""+(row)+(col+1))))
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

    public static void setStartingPositions(List<Player> players, Board gameBoard){
        GamePiece piece1 = new GamePiece("O"),
                piece2 = new GamePiece("O"),
                piece3 = new GamePiece("X"),
                piece4 = new GamePiece("X");

        GameRules.getLocationById(gameBoard, "D4").setPiece(piece1);
        players.get(0).getPieces().add(piece1);

        GameRules.getLocationById(gameBoard, "E5").setPiece(piece2);
        players.get(0).getPieces().add(piece2);

        GameRules.getLocationById(gameBoard, "D5").setPiece(piece3);
        players.get(1).getPieces().add(piece3);

        GameRules.getLocationById(gameBoard, "E4").setPiece(piece4);
        players.get(1).getPieces().add(piece4);
    }

}
