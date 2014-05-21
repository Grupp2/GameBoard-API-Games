package battleships.gui;

import game.api.GameState;
import game.io.InputUnit;

public class BattleShipsInputUnit extends InputUnit{
	private GameState state;
	
    @Override
    public void setup(GameState state) {
    	this.state = state;
        this.state.reset();
    }
    
    public void notifyListeners(String loc) {
	
    }

}
