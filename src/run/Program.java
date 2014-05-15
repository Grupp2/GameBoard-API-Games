package run;

import othello.backend.OthelloGameFacade;
import othello.consoleui.OthelloConsoleIOFactory;
import othello.gui.OthelloGameFrame;
import othello.gui.OthelloGuiInputUnit;
import game.init.Runner;

public class Program {

	public static void main(String[] args) {
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++)
				if (args[i].equals("--console") || args[i].equals("-c"))
					new Runner(new OthelloGameFacade(), new OthelloConsoleIOFactory()).run();
		} else {
			OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
			//OthelloGuiOutputUnit outputUnit = new OthelloGuiOutputUnit(new OthelloGameFrame(inputUnit));
			//new Runner(new OthelloGameFacade(), new OthelloGuiIOFactory(inputUnit, outputUnit)).run();
		}
	}
}
