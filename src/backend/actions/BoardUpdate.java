package backend.actions;

import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;
import backend.util.BoardParser;
import backend.util.GameRules;
import backend.State;

import java.util.List;


public class BoardUpdate {

    private Board board;
    private List<Player> players;
    private BoardLocation location;
    private BoardParser boardParser;

    public BoardUpdate(State state, BoardParser boardParser){
        this.players = state.getPlayers();
        this.board = state.getBoard();
        this.boardParser = boardParser;
        this.location = boardParser.getLocation();
    }

    public void execute(){
        updatePartial(boardParser.getRow());
        updatePartial(boardParser.getColumn());
        updatePartial(boardParser.getLeftToRightDiagonal());
        updatePartial(boardParser.getRightToLeftDiagonal());
    }


    private void updatePartial(List<BoardLocation> list){

        int locationIndex = list.indexOf(location);
        Player owner = getOwnerOfPiece(location.getPiece());

        int backWardsIndex = getBackwardsUpdateIndex(owner, list, locationIndex);
        for(int i = locationIndex - 1; i >= backWardsIndex; i--)
            changeOwnerOfPieceAtLocation(list.get(i));

        int forwardIndex = getForwardUpdateIndex(owner, list, locationIndex);
        for(int i = locationIndex + 1; i <= forwardIndex; i++)
            changeOwnerOfPieceAtLocation(list.get(i));

    }

    private Player getOwnerOfPiece(GamePiece piece){
        if(GameRules.isPlayerOnePiece(piece))
            return players.get(0);

        return players.get(1);
    }

    private void changeOwnerOfPieceAtLocation(BoardLocation location){
        GamePiece piece = location.getPiece();
        Player newOwner, oldOwner = getOwnerOfPiece(piece);
        String newPieceId;

        if(oldOwner == players.get(0)){
            newOwner = players.get(1);
            newPieceId = "X";
        }
        else{
            newOwner = players.get(0);
            newPieceId = "O";
        }

        oldOwner.getPieces().remove(piece);
        piece = new GamePiece(newPieceId);
        newOwner.getPieces().add(piece);
        location.setPiece(piece);
    }

    private int getBackwardsUpdateIndex(Player owner, List<BoardLocation> list, int startIndex){

        for(int i = startIndex-1; i >= 0; i-- ){

            if(GameRules.isLocationEmpty(list.get(i)))
                return startIndex;

            if(getOwnerOfPiece(list.get(i).getPiece()) == owner)
                return i+1;
        }


        return startIndex;
    }

    private int getForwardUpdateIndex(Player owner, List<BoardLocation> list, int startIndex){

        for(int i = startIndex+1; i < list.size(); i++) {
            if (GameRules.isLocationEmpty(list.get(i)))
                return startIndex;

            if (getOwnerOfPiece(list.get(i).getPiece()) == owner)
                return i-1;

        }

        return startIndex;
    }

}
