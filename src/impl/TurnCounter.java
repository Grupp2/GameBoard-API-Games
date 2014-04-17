package impl;

import java.util.List;

import game.impl.Player;

public class TurnCounter {

    private List<Player> players;
    private int currentTurn;
    private int lastTurn;

    public TurnCounter(List<Player> players){
        this.players = players;
        this.currentTurn = 0;
        this.lastTurn = -1;
    }

    public void increment(){
        lastTurn = currentTurn;
        currentTurn = (currentTurn+1) % players.size();
    }

    public Player getCurrentPlayer(){
        return players.get(currentTurn);
    }

    public Player getLastPlayer(){
        if(lastTurn == -1)
            return null;

        return players.get(lastTurn);
    }

}
