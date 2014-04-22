package run;

import impl.ActionHandler;
import impl.GameStateAdapter;
import impl.OthelloGameFactory;
import impl.State;
import io.OthelloIOFactory;
import game.init.Runner;

public class Program
 {

	public static void main(String[] args)
	{
        State state = new State();
		new Runner(new GameStateAdapter(state, new ActionHandler(state, new OthelloGameFactory())), new OthelloIOFactory());
	}

}
