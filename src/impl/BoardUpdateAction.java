package impl;

import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Player;

import java.util.List;


public class BoardUpdateAction {

    private Board board;
    private List<Player> players;
    private BoardLocation location;
    private BoardParser boardParser;

    public BoardUpdateAction(OthelloGameState gameState, BoardParser boardParser){
        this.players = gameState.getPlayers();
        this.board = gameState.getBoard();
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
            if(GameRules.isLocationEmpty(list.get(i)) || getOwnerOfPiece(list.get(i).getPiece()) == owner)
                break;

            changeOwnerOfPieceAtLocation(list.get(i));
        }

        for(int i = locationIndex+1; i < list.size(); i++){
            if(GameRules.isLocationEmpty(list.get(i)) || getOwnerOfPiece(list.get(i).getPiece()) == owner)
                break;

            changeOwnerOfPieceAtLocation(list.get(i));
        }
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
