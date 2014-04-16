package impl;

import game.api.GameState;
import game.impl.*;

import java.util.ArrayList;
import java.util.List;

public class OthelloGameState implements GameState {

    private List<Player> players;
    private Board gameBoard;

    public OthelloGameState(){
        reset();
    }
    @Override
    public List<Player> getPlayers() {
        return null;
    }

    @Override
    public Player getLastPlayer() {
        return null;
    }

    @Override
    public Player getPlayerInTurn() {
        return null;
    }

    @Override
    public Board getBoard() {
        return null;
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
        return null;
    }

    @Override
    public void reset() {
        players = new ArrayList<Player>();

        gameBoard = new Board(makeBoardLocations());


        players.add(new Player("P1", makePlayerOneGamePieces()));
        players.add(new Player("P2", makePlayerTwoGamePieces()));

    }

    private List<GamePiece> makePlayerOneGamePieces(){
        return null;
    }

    private List<GamePiece> makePlayerTwoGamePieces(){
        return null;
    }

    private List<BoardLocation> makeBoardLocations(){

        List<BoardLocation> list = new ArrayList<BoardLocation>();

        for(int i = 0; i < 8; i++){
            for(int j = (int)'A'; i < (int)'I'; j++){
                list.add(new BoardLocation(""+(char)j+i));
            }
        }

        return list;
    }
}
