package gui;


import game.api.GameState;
import game.impl.Move;
import game.io.InputUnit;

public class GameInputUnit extends InputUnit{
    @Override
    public void setup(GameState gameState) {}

    public void executeMove(Move move){
        notifyListenersOfMove(move);
    }
}
