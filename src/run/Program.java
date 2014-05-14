package run;

import backend.OthelloGameFacade;
import io.OthelloConsoleIOFactory;
import game.init.Runner;
import gui.OthelloGameFrame;
import gui.OthelloGuiIOFactory;
import gui.OthelloGuiInputUnit;
import gui.OthelloGuiOutputUnit;

public class Program {

	public static void main(String[] args) {
		if (args.length > 0) {
			for (int i = 0; i < args.length; i++)
				if (args[i].equals("-console") || args[i].equals("-c"))
					new Runner(new OthelloGameFacade(), new OthelloConsoleIOFactory()).run();
		} else {
			OthelloGuiInputUnit inputUnit = new OthelloGuiInputUnit();
			OthelloGuiOutputUnit outputUnit = new OthelloGuiOutputUnit(new OthelloGameFrame(inputUnit));
			new Runner(new OthelloGameFacade(), new OthelloGuiIOFactory(inputUnit, outputUnit)).run();
		}
	}
}
