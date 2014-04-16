package run;

import game.init.Runner;
import impl.OthelloGameState;
import io.OthelloIOFactory;

public class Program
{

	public static void main(String[] args)
	{
		new Runner(new OthelloGameState(), new OthelloIOFactory());
	}

}
