package run;

import impl.OthelloGameState;
import io.OthelloConsoleIOFactory;
import game.init.Runner;

public class Program
 {

	public static void main(String[] args) {
		new Runner(new OthelloGameState(), new OthelloConsoleIOFactory()).run();
	}

}
