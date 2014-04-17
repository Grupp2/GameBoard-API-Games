package src.impl;

import game.api.GameState;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.Player;

public class RuleChecker {

    private GameState gameState;

    public RuleChecker(GameState gameState){
        this.gameState = gameState;
    }

    public boolean isValidMove(Move move){
        return false;
    }

    public boolean isGameOver(){
        return false;

    }

    public Player getLeader(){
        return null;
    }

}
