package impl;

import game.api.GameState;
import game.impl.*;

import java.util.List;

public class OthelloGameState implements GameState {

    private OthelloGameFactory factory;

    private List<Player> players;
    private Board gameBoard;

    private TurnCounter turnCounter;

    private String message;


    public OthelloGameState(OthelloGameFactory factory){
        this.factory = factory;
        reset();
    }

    public OthelloGameState(){
        this(new OthelloGameFactory());
        reset();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Board getBoard() {
        return gameBoard;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public DieRollFactory getDieRollFactory() {
        return null;
    }

    @Override
    public Player getLastPlayer() {
        return turnCounter.getLastPlayer();
    }

    @Override
    public Player getPlayerInTurn() {
        return turnCounter.getCurrentPlayer();
    }

    @Override
    public Player getWinner() {
        int playerOneScore = GameRules.getPlayerScore(players.get(0)),
            playerTwoScore = GameRules.getPlayerScore(players.get(1));

        if(playerOneScore > playerTwoScore)
            return players.get(0);
        else if(playerOneScore < playerTwoScore)
            return players.get(1);

        return null;
    }

    @Override
    public Boolean hasEnded() {
        return players.get(0).getPieces().size() + players.get(1).getPieces().size() >= 64;
    }

    @Override
    public Boolean proposeMove(Move move) {
        if(isValidMove(move)){
            executeMove(move);
            return true;
        }
        return false;
    }

    private boolean isValidMove(Move move){
        if(move.getPlayer() != getPlayerInTurn()){
            message = "It's not your turn!";
            return false;
        }

        if(!GameRules.isLocationEmpty(move.getDestination())){
            message = "There is already a piece in that location!";
            return false;
        }

        if(move.getSource() != null){
            message = "You cannot move a piece already placed on the board.";
            return false;
        }

        if(!GameRules.isLocationNextToPiece(gameBoard, move.getDestination())){
            message = "You have to put your piece next to an existing one.";
            return false;
        }

        message = "";
        return true;
    }

    private void executeMove(Move move){
        move.execute();
        GamePiece piece = move.getPiece();

        if(GameRules.isPlayerOnePiece(piece))
            players.get(0).getPieces().add(piece);
        else
            players.get(1).getPieces().add(piece);

        new BoardUpdateAction(this, new BoardParser(gameBoard, move.getDestination())).execute();
        turnCounter.increment();
    }

    @Override
    public void reset() {
        gameBoard = factory.createBoard();
        players = factory.createPlayers();
        turnCounter = factory.createTurnCounter(players);

        GamePiece   piece1 = new GamePiece("O"),
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

        message = "";
    }


}
