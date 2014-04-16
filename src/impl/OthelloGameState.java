package impl;

import game.api.GameState;
import game.impl.Board;
import game.impl.Move;
import game.impl.Player;

import java.util.List;

public class OthelloGameState implements GameState {
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

    }
}
