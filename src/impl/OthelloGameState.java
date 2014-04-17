package impl;

import game.api.GameState;
import game.impl.*;

import java.util.ArrayList;
import java.util.List;

public class OthelloGameState implements GameState {

    private List<Player> players;
    private Board gameBoard;
    private Player lastPlayer;

    private int turnCounter;
    private String message;


    public OthelloGameState(List<Player> players, Board gameBoard){
        reset();
        this.players = players;
        this.gameBoard = gameBoard;
    }

    public OthelloGameState(){
        reset();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Player getLastPlayer() {
        return null;
    }

    @Override
    public Player getPlayerInTurn() {
        return players.get(turnCounter);
    }

    @Override
    public Board getBoard() {
        return gameBoard;
    }

    @Override
    public Boolean hasEnded() {
        return null;
    }

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public Boolean proposeMove(Move move) {
        return null;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void reset() {
        gameBoard = new Board(makeBoardLocations());

        players = new ArrayList<Player>();
        players.add(new Player("P1", makePlayerOneGamePieces()));
        players.add(new Player("P2", makePlayerTwoGamePieces()));

        turnCounter = 0;
        message = "";
    }

    private List<GamePiece> makePlayerOneGamePieces(){
        List<GamePiece> list = new ArrayList<GamePiece>();

        for(int i = 0; i < 32; i++)
            list.add(new GamePiece("O"));

        return list;
    }

    private List<GamePiece> makePlayerTwoGamePieces(){
        List<GamePiece> list = new ArrayList<GamePiece>();

        for(int i = 0; i < 32; i++)
            list.add(new GamePiece("X"));

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
