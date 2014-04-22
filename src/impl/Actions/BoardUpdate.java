package impl.Actions;

import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;
import impl.util.BoardParser;
import impl.util.GameRules;
import impl.State;

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

        for(int i = locationIndex-1; i >= 0; i-- ){
            if(listEnded(list.get(i), owner))
                break;

            changeOwnerOfPieceAtLocation(list.get(i));
        }

        for(int i = locationIndex+1; i < list.size(); i++){
            if(listEnded(list.get(i), owner))
                break;

            changeOwnerOfPieceAtLocation(list.get(i));
        }
    }

    private boolean listEnded(BoardLocation location, Player owner){
        return GameRules.isLocationEmpty(location) || getOwnerOfPiece(location.getPiece()) == owner;
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
}
