package src.run;

import src.impl.OthelloGameState;
import src.io.OthelloIOFactory;
import game.init.Runner;

public class Program
{

	public static void main(String[] args)
	{
		new Runner(new OthelloGameState(), new OthelloIOFactory());
	}

}
