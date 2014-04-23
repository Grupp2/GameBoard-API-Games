package run;

import game.api.GameState;
import impl.ActionHandler;
import impl.GameStateAdapter;
import impl.OthelloGameFactory;
import impl.State;
import io.OthelloIOFactory;
import game.init.Runner;

import javax.swing.*;

public class Program
 {

	public static void main(String[] args)
	{
        State state = new State();
        ActionHandler actionHandler = new ActionHandler(state, new OthelloGameFactory());
        GameState gameState = new GameStateAdapter(state, actionHandler);

		new Runner(gameState, new OthelloIOFactory());
	}

}
